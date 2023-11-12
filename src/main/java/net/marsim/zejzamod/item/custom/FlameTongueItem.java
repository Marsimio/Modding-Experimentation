package net.marsim.zejzamod.item.custom;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;

public class FlameTongueItem extends SwordItem {
    public FlameTongueItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        Level world = target.level();
        if (!world.isClientSide) {
            target.setSecondsOnFire(3);

            world.explode(
                    attacker,
                    target.getX(),
                    target.getY(),
                    target.getZ(),
                    3.0F,
                    Level.ExplosionInteraction.NONE
            );
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}
