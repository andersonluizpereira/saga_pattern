package com.pereira.inventory.inventory.adapters.out;

import com.pereira.inventory.inventory.adapters.out.repository.InventoryRepository;
import com.pereira.inventory.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.pereira.inventory.inventory.application.core.domain.Inventory;
import com.pereira.inventory.inventory.application.ports.out.FindInventoryByProductIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindInventoryByProductIdAdapter implements FindInventoryByProductIdOutputPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public Optional<Inventory> find(Integer productId) {
        var inventoryEntity = inventoryRepository.findByProductId(productId);
        return inventoryEntity.map(inventoryEntityMapper::toInventory);
    }

}
