package com.graphQl.GraphQL.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphQl.GraphQL.dto.VehicleDto;
import com.graphQl.GraphQL.entity.Vehicle;
import com.graphQl.GraphQL.repo.VehicleRepository;
import java.util.Date;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    /*CREATE UPDATE DELETE*/

        private final VehicleRepository vehicleRepository;

        /*save what data came from api*/
        public Vehicle createVehicle(VehicleDto vehicleDto) {
            return vehicleRepository.save(dtoToEntity(vehicleDto));
        }

        /*setting data which came from api*/
        private Vehicle dtoToEntity(VehicleDto vehicleDto){
            Vehicle vehicle=new Vehicle();
            vehicle.setBrandName(vehicleDto.getBrandName());
            vehicle.setLaunchDate(new Date());
            vehicle.setModelCode(vehicleDto.getModelCode());
            vehicle.setType(vehicleDto.getType());
            return vehicle;
        }
    }


