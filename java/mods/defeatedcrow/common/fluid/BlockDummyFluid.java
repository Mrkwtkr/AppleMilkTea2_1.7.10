package mods.defeatedcrow.common.fluid;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*
 * 0~2:焼酎、ウィスキー、ブランデーのYoung
 * 3~5:焼酎、ウィスキー、ブランデー
 * */

public class BlockDummyFluid extends Block {
	
	@SideOnly(Side.CLIENT)
	protected IIcon baseIcon[];
	
	private String[] iconType = new String[] {"shothu_still", "whiskey_still", "brandy_still"};

	public BlockDummyFluid() {
		super(Material.water);
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		MathHelper.clamp_int(meta, 0, 5);
		if (meta == 4)
		{
			return this.baseIcon[1];
		}
		else if (meta == 5)
		{
			return this.baseIcon[2];
		}
		else
		{
			return this.baseIcon[0];
		}
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister par1IconRegister)
	{
		this.baseIcon = new IIcon[3];
		for (int i = 0; i < 3; ++i)
        {
            this.baseIcon[i] = par1IconRegister.registerIcon("defeatedcrow:fluid/" + this.iconType[i]);
        }
		
	}

}
