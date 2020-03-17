package net.minecraft.entity;

import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

public abstract class CreatureEntity extends MobEntity {
   protected CreatureEntity(EntityType<? extends CreatureEntity> type, World worldIn) {
      super(type, worldIn);
   }

   public float getBlockPathWeight(BlockPos pos) {
      return this.getBlockPathWeight(pos, this.world);
   }

   public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
      return 0.0F;
   }

   public boolean canSpawn(IWorld worldIn, SpawnReason spawnReasonIn) {
      return this.getBlockPathWeight(new BlockPos(this), worldIn) >= 0.0F;
   }

   public boolean hasPath() {
      return !this.getNavigator().noPath();
   }

   protected void updateLeashedState() {
      super.updateLeashedState();
      Entity entity = this.getLeashHolder();
      if (entity != null && entity.world == this.world) {
         this.setHomePosAndDistance(new BlockPos(entity), 5);
         float f = this.getDistance(entity);
         if (this instanceof TameableEntity && ((TameableEntity)this).isSitting()) {
            if (f > 10.0F) {
               this.clearLeashed(true, true);
            }

            return;
         }

         this.onLeashDistance(f);
         if (f > 10.0F) {
            this.clearLeashed(true, true);
            this.goalSelector.disableFlag(Goal.Flag.MOVE);
         } else if (f > 6.0F) {
            double d0 = (entity.func_226277_ct_() - this.func_226277_ct_()) / (double)f;
            double d1 = (entity.func_226278_cu_() - this.func_226278_cu_()) / (double)f;
            double d2 = (entity.func_226281_cx_() - this.func_226281_cx_()) / (double)f;
            this.setMotion(this.getMotion().add(Math.copySign(d0 * d0 * 0.4D, d0), Math.copySign(d1 * d1 * 0.4D, d1), Math.copySign(d2 * d2 * 0.4D, d2)));
         } else {
            this.goalSelector.enableFlag(Goal.Flag.MOVE);
            float f1 = 2.0F;
            Vec3d vec3d = (new Vec3d(entity.func_226277_ct_() - this.func_226277_ct_(), entity.func_226278_cu_() - this.func_226278_cu_(), entity.func_226281_cx_() - this.func_226281_cx_())).normalize().scale((double)Math.max(f - 2.0F, 0.0F));
            this.getNavigator().tryMoveToXYZ(this.func_226277_ct_() + vec3d.x, this.func_226278_cu_() + vec3d.y, this.func_226281_cx_() + vec3d.z, this.followLeashSpeed());
         }
      }

   }

   protected double followLeashSpeed() {
      return 1.0D;
   }

   protected void onLeashDistance(float p_142017_1_) {
   }
}