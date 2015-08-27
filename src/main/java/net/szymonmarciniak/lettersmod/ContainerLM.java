package net.szymonmarciniak.lettersmod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerLM extends Container{

	public static enum State
    {
        ERROR, READY
    }

    public InvLMIn inputInventory = new InvLMIn();
    public int inputSlotNumber;
    public InvLMOut outputInventory = new InvLMOut();
    private final World worldObj;
    public InventoryPlayer playerInventory;
    public String resultString = "deconstructing.result.ready";
    public State deconstructingState = State.READY;
    public int x = 0;
    public int y = 0;
    public int z = 0;
	
    public ContainerLM(
            InventoryPlayer parPlayerInventory, 
            World parWorld, 
            int parX, 
            int parY, 
            int parZ
            )
      {
          x = parX;
          y = parY;
          z = parZ;
          worldObj = parWorld;
          
          
          inputSlotNumber = addSlotToContainer(new Slot(inputInventory, 0, 30 + 15, 35))
                .slotNumber;

          for(int playerSlotIndexY = 0; playerSlotIndexY < 3; ++playerSlotIndexY)
          {
              for(int playerSlotIndexX = 0; playerSlotIndexX < 9; ++playerSlotIndexX)
              {
                  addSlotToContainer(new Slot(parPlayerInventory, playerSlotIndexX + 
                        playerSlotIndexY * 9 + 9, 8 + playerSlotIndexX * 18, 
                        84 + playerSlotIndexY * 18));
              }
          }
          
          for(int hotbarSlotIndex = 0; hotbarSlotIndex < 9; ++hotbarSlotIndex)
          {
              addSlotToContainer(new Slot(parPlayerInventory, hotbarSlotIndex, 
                    8 + hotbarSlotIndex * 18, 142));
          }     
          
          playerInventory = parPlayerInventory;
      }

    @Override
    public ItemStack slotClick(
          int parSlotId, 
          int parMouseButtonId, 
          int parClickMode, 
          EntityPlayer parPlayer
          )
    {
        ItemStack clickItemStack = super.slotClick(parSlotId, parMouseButtonId, 
              parClickMode, parPlayer);
        if(inventorySlots.size() > parSlotId && parSlotId >= 0)
        {
            if(inventorySlots.get(parSlotId) != null)
            {
                if(((Slot) inventorySlots.get(parSlotId)).inventory == inputInventory)
                {
                    onCraftMatrixChanged(inputInventory);
                }
            }
        }
        return clickItemStack;
    }

    /**
     * Callback for when the crafting gui is closed.
     */
    @Override
    public void onContainerClosed(EntityPlayer parPlayer)
    {
        if(playerInventory.getItemStack() != null)
        {
            parPlayer.entityDropItem(playerInventory.getItemStack(), 0.5f);
        }
        if(!worldObj.isRemote)
        {
            ItemStack itemStack = inputInventory.getStackInSlotOnClosing(0);
            if(itemStack != null)
            {
                parPlayer.entityDropItem(itemStack, 0.5f);
            }

            for(int i = 0; i < outputInventory.getSizeInventory(); i++ )
            {
                itemStack = outputInventory.getStackInSlotOnClosing(i);

                if(itemStack != null)
                {
                    parPlayer.entityDropItem(itemStack, 0.5f);
                }
            }
        }
    }
    
	@Override
	public boolean canInteractWith(EntityPlayer playerIn) {
		// TODO Auto-generated method stub
		return true;
	}
	

    /**
     * Called when a player shift-clicks on a slot.
     */
    @Override
    public ItemStack transferStackInSlot(EntityPlayer parPlayer, int parSlotIndex)
    {
        Slot slot = (Slot) inventorySlots.get(parSlotIndex);
        // If there is something in the stack to pick up
        if (slot != null && slot.getHasStack())
        {
            // If the slot is one of the custom slots
            if (slot.inventory.equals(inputInventory) || slot.inventory
                   .equals(outputInventory))
            {
                // try to move to player inventory
                if (!playerInventory.addItemStackToInventory(slot.getStack()))
                {
                    return null;
                }
                slot.putStack(null);
                slot.onSlotChanged();
            }
            // if the slot is a player inventory slot
            else if(slot.inventory.equals(playerInventory))
            {
                // DEBUG
                System.out.println("Shift-clicked on player inventory slot");
                // Try to transfer to input slot
                if (!((Slot)inventorySlots.get(inputSlotNumber)).getHasStack())
                {
                    ((Slot)inventorySlots.get(inputSlotNumber)).putStack(slot.getStack());
                    slot.putStack(null);
                    slot.onSlotChanged();
                }
                else
                {
                    // DEBUG
                    System.out.println("There is already something in the input slot");
                }
            }
        }
        return null;
    }

    @Override
    public boolean canMergeSlot(ItemStack parItemStack, Slot parSlot)
    {
        return !parSlot.inventory.equals(outputInventory);
    }

    @Override
    public Slot getSlot(int parSlotIndex)
    {
        if(parSlotIndex >= inventorySlots.size())
            parSlotIndex = inventorySlots.size() - 1;
        return super.getSlot(parSlotIndex);
    }


}
