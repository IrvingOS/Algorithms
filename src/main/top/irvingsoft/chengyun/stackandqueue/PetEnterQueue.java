package top.irvingsoft.chengyun.stackandqueue;

/**
 * Page 28
 * <p>
 * 宠物进队
 *
 * @author TimeChaser
 * @since 2021/8/8 14:45
 */
public class PetEnterQueue {

    private final long count;
    private final Pet pet;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }

    public Pet getPet() {
        return this.pet;
    }

}
