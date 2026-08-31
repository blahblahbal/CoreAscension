package com.blah.coreascension.world.tree.placers;

import com.blah.coreascension.block.CoreAscensionBlocks;
import com.blah.coreascension.world.tree.CoreAscensionFoliagePlacerTypes;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;

public class DarkMatterFoliagePlacer extends FoliagePlacer
{
    public static final Codec<DarkMatterFoliagePlacer> CODEC = RecordCodecBuilder.create(popsicleFoliagePlacerInstance ->
            fillFoliagePlacerFields(popsicleFoliagePlacerInstance).and(Codec.intRange(0, 15).fieldOf("height")
                    .forGetter(instance -> instance.height)).apply(popsicleFoliagePlacerInstance, DarkMatterFoliagePlacer::new));

    private final int height;

    public DarkMatterFoliagePlacer(IntProvider radius, IntProvider offset, int height)
    {
        super(radius, offset);
        this.height = height;
    }

    @Override
    protected FoliagePlacerType<?> getType() {
        return CoreAscensionFoliagePlacerTypes.DARK_MATTER_FOLIAGE_PLACER;
    }

    @Override
    protected void generate(TestableWorld world, BlockPlacer placer, Random random, TreeFeatureConfig config, int trunkHeight, TreeNode treeNode, int foliageHeight, int radius, int offset)
    {
        int style = random.nextBetween(0, 1);

        if (style == 0)
        {
            int randomSide = random.nextBetween(0, 3);
            BlockPos side;
            if (randomSide == 0)
            {
                side = treeNode.getCenter().north();
            }
            else if (randomSide == 1)
            {
                side = treeNode.getCenter().east();
            }
            else if (randomSide == 2)
            {
                side = treeNode.getCenter().south();
            }
            else
            {
                side = treeNode.getCenter().west();
            }

            for (int y = 0; y <= 5; y++)
            {
                placer.placeBlock(side.add(0, y, 0), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            }
            placer.placeBlock(side.north().up(2), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.east().up(2), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.south().up(2), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.west().up(2), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            placer.placeBlock(side.north(2).up(3), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.east(2).up(3), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.south(2).up(3), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(side.west(2).up(3), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            for (int x = -2; x <= 2; x++)
            {
                for (int z = -2; z <= 2; z++)
                {
                    if (x == -2 || x == 2 || z == -2 || z == 2)
                    {
                        placeFoliageBlock(world, placer, random, config, side.add(x, 3, z));
                    }
                    placeFoliageBlock(world, placer, random, config, side.add(x, 4, z));

                    if (x == -2 || x == 2)
                    {
                        if (z == 0)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 5, z));
                    }
                    if (z == -2 || z == 2)
                    {
                        if (x == 0)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 5, z));
                    }
                }
            }

            for (int x = -1; x <= 1; x++)
            {
                for (int z = -1; z <= 1; z++)
                {
                    placeFoliageBlock(world, placer, random, config, side.add(x, 5, z));
                    if ((x == -1 && z == -1) || (x == -1 && z == 1) || (x == 1 && z == -1) || (x == 1 && z == 1)) continue;
                    placeFoliageBlock(world, placer, random, config, side.add(x, 6, z));
                }
            }

            for (int x = -3; x <= 3; x++)
            {
                for (int z = -3; z <= 3; z++)
                {
                    if (x == -3 || x == 3)
                    {
                        if (z >= -1 && z <= 1)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 3, z));
                        if (z == 0)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 4, z));
                    }
                    if (z == -3 || z == 3)
                    {
                        if (x >= -1 && x <= 1)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 3, z));
                        if (x == 0)
                            placeFoliageBlock(world, placer, random, config, side.add(x, 4, z));
                    }
                }
            }
        }
        else if (style == 1)
        {
            int randomSide = random.nextBetween(0, 3);
            BlockPos branch1Pos1;
            BlockPos branch1Pos2;
            BlockPos branch1Pos3;
            BlockPos branch2Pos1;
            BlockPos branch2Pos2;
            BlockPos branch3Pos1;
            BlockPos branch3Pos2;

            if (randomSide == 0)
            {
                branch1Pos1 = treeNode.getCenter().up().west();
                branch1Pos2 = treeNode.getCenter().up(2).west(2).south();
                branch1Pos3 = treeNode.getCenter().up(3).west(3).south(2);

                branch2Pos1 = treeNode.getCenter().up().north();
                branch2Pos2 = treeNode.getCenter().up(2).north(2);

                branch3Pos1 = treeNode.getCenter().up().east().south();
                branch3Pos2 = treeNode.getCenter().up(2).east(2).south();
            }
            else if (randomSide == 1)
            {
                branch1Pos1 = treeNode.getCenter().up().north();
                branch1Pos2 = treeNode.getCenter().up(2).north(2).west();
                branch1Pos3 = treeNode.getCenter().up(3).north(3).west(2);

                branch2Pos1 = treeNode.getCenter().up().east();
                branch2Pos2 = treeNode.getCenter().up(2).east(2);

                branch3Pos1 = treeNode.getCenter().up().south().west();
                branch3Pos2 = treeNode.getCenter().up(2).south(2).west();
            }
            else if (randomSide == 2)
            {
                branch1Pos1 = treeNode.getCenter().up().east();
                branch1Pos2 = treeNode.getCenter().up(2).east(2).north();
                branch1Pos3 = treeNode.getCenter().up(3).east(3).north(2);

                branch2Pos1 = treeNode.getCenter().up().south();
                branch2Pos2 = treeNode.getCenter().up(2).south(2);

                branch3Pos1 = treeNode.getCenter().up().west().north();
                branch3Pos2 = treeNode.getCenter().up(2).west(2).north();
            }
            else
            {
                branch1Pos1 = treeNode.getCenter().up().south();
                branch1Pos2 = treeNode.getCenter().up(2).south(2).east();
                branch1Pos3 = treeNode.getCenter().up(3).south(3).east(2);

                branch2Pos1 = treeNode.getCenter().up().west();
                branch2Pos2 = treeNode.getCenter().up(2).west(2);

                branch3Pos1 = treeNode.getCenter().up().north().east();
                branch3Pos2 = treeNode.getCenter().up(2).north(2).east();
            }

            placer.placeBlock(treeNode.getCenter(), CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            placer.placeBlock(branch1Pos1, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(branch1Pos2, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(branch1Pos3, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            placer.placeBlock(branch2Pos1, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(branch2Pos2, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            placer.placeBlock(branch3Pos1, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());
            placer.placeBlock(branch3Pos2, CoreAscensionBlocks.DARK_MATTER_LOG.getDefaultState());

            for (int x = -1; x <= 1; x++)
            {
                for (int y = -1; y <= 1; y++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        if (((x == -1 && z == -1) || (x == -1 && z == 1) || (x == 1 && z == -1) || (x == 1 && z == 1)) && (y == -1 || y == 1)) continue;
                        placeFoliageBlock(world, placer, random, config, branch1Pos2.add(x, y, z));
                        placeFoliageBlock(world, placer, random, config, branch1Pos3.add(x, y, z));
                        placeFoliageBlock(world, placer, random, config, branch2Pos2.add(x, y, z));
                        placeFoliageBlock(world, placer, random, config, branch3Pos2.add(x, y, z));
                    }
                }
            }
        }
    }

    @Override
    public int getRandomHeight(Random random, int trunkHeight, TreeFeatureConfig config) {
        return height;
    }

    @Override
    protected boolean isInvalidForLeaves(Random random, int dx, int y, int dz, int radius, boolean giantTrunk) {
        return false;
    }
}
