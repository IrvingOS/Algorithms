package top.irvingsoft.chengyun.stackandqueue;

/**
 * Page 28
 * <p>
 * 宠物进队
 *
 * @author TimeChaser
 * @date 2021/8/8 14:45
 */
public class PetEnterQueue {

    private final Pet pet;
    private final long count;

    public PetEnterQueue(Pet pet, long count) {
        this.pet = pet;
        this.count = count;
    }

    public Pet getPet() {
        return this.pet;
    }

    public long getCount() {
        return this.count;
    }

    public String getEnterPetType() {
        return this.pet.getPetType();
    }
}