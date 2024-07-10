package veg.vegi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import veg.vegi.domain.Place;
import veg.vegi.repositories.PlaceRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;


@Service
public class PlaceService {

    @Autowired
    PlaceRepository repository;

    public Place save(Place place){
        return repository.save(place);
    }

    public List<Place> lista(){
        return repository.findAll();
    }

    public List<Place> att(double x2, double y2, double raio){
        var atualizado = lista();
        var nova = new ArrayList<Place>();

        for(Place p: atualizado){
            double lat1 = x2;
            double lon1 = y2;
            double lat2 = p.getX();
            double lon2 = p.getY();

            double radLat1 = Math.toRadians(lat1);
            double radLon1 = Math.toRadians(lon1);
            double radLat2 = Math.toRadians(lat2);
            double radLon2 = Math.toRadians(lon2);

            double earthRadius = 6371.0;

            double dLon = radLon2 - radLon1;
            double dLat = radLat2 - radLat1;

            double a = Math.pow(Math.sin(dLat / 2), 2) +
                    Math.cos(radLat1) * Math.cos(radLat2) *
                            Math.pow(Math.sin(dLon / 2), 2);
            double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
            double distance = earthRadius * c;

            if (distance <= raio || p.getAddress().equals("-")) {
                p.setDistance(distance);
                nova.add(p);
            }
        }
        nova.sort(Comparator.comparingDouble(Place::getDistance));
        return nova;
    }
}
