package net.szymonmarciniak.lettersmod.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.szymonmarciniak.lettersmod.LettersMod;

public class BlockLetters extends Block{

	public static final PropertyDirection FACING = PropertyDirection.create("facing");
	
	public BlockLetters(Material materialIn) {
		super(materialIn);
	}
	
	
	public boolean isOpaqueCube(){
		return false;
	}
	
	public boolean isFullCube(){
		return false;
	}
	
	  public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumFacing side, float hitX, float hitY, float hitZ)
	    {
	    	
	    	
	    	System.out.println("NU SE QUE SERA \n YA tengo una idea de que es ="+FACING);
	    	

	    	Block fur = Blocks.furnace;
	    	
	    	fur.getActualState(state, worldIn, pos);
	    	IBlockState state1 = fur.getDefaultState();
	    	    	
	    	//worldIn.setBlockState(pos, state);
	    	
			worldIn.setBlockState(pos, state.withProperty(FACING, side), 2);
	    	    	
	    	
	    return false;}
	    
	  //###########################################################3

	    public void onNeighborBlockChange(World worldIn, BlockPos pos, IBlockState state, Block neighborBlock)
	    {
	    	
	    }
	    
	  //###########################################################3
	    
	    
	    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
	    {
	        worldIn.setBlockState(pos, state.withProperty(FACING, getFacingFromEntity(worldIn, pos, placer)), 2);

	     
	    }
	    
	  //###########################################################3    
	    public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	    {
	        return this.getDefaultState().withProperty(FACING, getFacingFromEntity(worldIn, pos, placer));
	    }
	    
	  //###########################################################3    
	    public void setBlockBoundsBasedOnState(IBlockAccess worldIn, BlockPos pos)
	    {
	        IBlockState iblockstate = worldIn.getBlockState(pos);

	       
	            float f = 0.25F;
	            EnumFacing enumfacing = (EnumFacing)iblockstate.getValue(FACING);

	            if (enumfacing != null)
	            {
	                switch (BlockLetters.SwitchEnumFacing.FACING_LOOKUP[enumfacing.ordinal()])
	                {
	                    case 1:
	                        this.setBlockBounds(0.0F, 0.25F, 0.0F, 1.0F, 1.0F, 1.0F);
	                        break;
	                    case 2:
	                        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	                        break;
	                    case 3:
	                        this.setBlockBounds(0.0F, 0.0F, 0.25F, 1.0F, 1.0F, 1.0F);
	                        break;
	                    case 4:
	                        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.75F);
	                        break;
	                    case 5:
	                        this.setBlockBounds(0.25F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	                        break;
	                    case 6:
	                        this.setBlockBounds(0.0F, 0.0F, 0.0F, 0.75F, 1.0F, 1.0F);
	                }
	            }
	        
	        else
	        {
	            this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	        }
	    }

	  //###########################################################3  
	    public void setBlockBoundsForItemRender()
	    {
	        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
	    }    
	        
	  //###########################################################3  
	    
	    public static EnumFacing getFacingFromEntity(World worldIn, BlockPos clickedBlock, EntityLivingBase entityIn)
	    {
	        if (MathHelper.abs((float)entityIn.posX - (float)clickedBlock.getX()) < 2.0F && MathHelper.abs((float)entityIn.posZ - (float)clickedBlock.getZ()) < 2.0F)
	        {
	            double d0 = entityIn.posY + (double)entityIn.getEyeHeight();

	            if (d0 - (double)clickedBlock.getY() > 2.0D)
	            {
	                return EnumFacing.UP;
	            }

	            if ((double)clickedBlock.getY() - d0 > 0.0D)
	            {
	                return EnumFacing.DOWN;
	            }
	        }

	        return entityIn.getHorizontalFacing().getOpposite();
	    } 
	  
	  //###########################################################3     
	    
	    @SideOnly(Side.CLIENT)
	    public IBlockState getStateForEntityRender(IBlockState state)
	    {
	        return this.getDefaultState().withProperty(FACING, EnumFacing.UP);
	    }
	    
	    //###########################################################3
	    
	    protected BlockState createBlockState()
	    {
	        return new BlockState(this, new IProperty[] {FACING});
	    }
	    
	    //###########################################################3
	    
	    public int getMetaFromState(IBlockState state)
	    {
	        byte b0 = 0;
	        int i = b0 | ((EnumFacing)state.getValue(FACING)).getIndex();

	       
	        return i;
	    }
	    
	    //###########################################################3
	    
	    static final class SwitchEnumFacing
	    {
	        static final int[] FACING_LOOKUP = new int[EnumFacing.values().length];
	        private static final String __OBFID = "CL_00002037";

	        static
	        {
	            try
	            {
	                FACING_LOOKUP[EnumFacing.DOWN.ordinal()] = 1;
	            }
	            catch (NoSuchFieldError var6)
	            {
	                ;
	            }

	            try
	            {
	                FACING_LOOKUP[EnumFacing.UP.ordinal()] = 2;
	            }
	            catch (NoSuchFieldError var5)
	            {
	                ;
	            }

	            try
	            {
	                FACING_LOOKUP[EnumFacing.NORTH.ordinal()] = 3;
	            }
	            catch (NoSuchFieldError var4)
	            {
	                ;
	            }

	            try
	            {
	                FACING_LOOKUP[EnumFacing.SOUTH.ordinal()] = 4;
	            }
	            catch (NoSuchFieldError var3)
	            {
	                ;
	            }

	            try
	            {
	                FACING_LOOKUP[EnumFacing.WEST.ordinal()] = 5;
	            }
	            catch (NoSuchFieldError var2)
	            {
	                ;
	            }

	            try
	            {
	                FACING_LOOKUP[EnumFacing.EAST.ordinal()] = 6;
	            }
	            catch (NoSuchFieldError var1)
	            {
	                ;
	            }
	        }
	    }
	   
	
}
