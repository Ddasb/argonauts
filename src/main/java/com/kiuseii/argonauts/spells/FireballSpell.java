package com.kiuseii.argonauts.spells;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.entity.projectile.SmallFireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class FireballSpell extends Spell {
  public FireballSpell() {
    super(10, 20, 50, 0, "Fireball");
  }

  @Override
  public void cast(Entity target) {
    if (target instanceof Player) {
      Player player = (Player) target;
      Vec3 look = player.getLookAngle();
      Level level = player.level;
      Fireball fireball = new SmallFireball(level, player, look.x, look.y, look.z);
      fireball.setPos(player.getX(), player.getEyeY(), player.getZ());
      fireball.setOwner(player);
      fireball.setDeltaMovement(look.x * 0.1D, look.y * 0.1D, look.z * 0.1D);

      level.addFreshEntity(fireball);
    }
  }
}