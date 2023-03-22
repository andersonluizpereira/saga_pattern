package com.pereira.inventory.adapters.out;

import com.pereira.inventory.adapters.out.repository.InventoryRepository;
import com.pereira.inventory.adapters.out.repository.entity.InventoryEntity;
import com.pereira.inventory.adapters.out.repository.mapper.InventoryEntityMapper;
import com.pereira.inventory.application.core.domain.Inventory;
import com.pereira.inventory.application.ports.out.UpdateInventoryOutPutPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateInventoryAdapter implements UpdateInventoryOutPutPort {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryEntityMapper inventoryEntityMapper;

    @Override
    public void update(Inventory inventory) {
        var inventoryEntity = inventoryEntityMapper.toInventoryEntity(inventory);
        inventoryRepository.save(inventoryEntity);
    }
}
