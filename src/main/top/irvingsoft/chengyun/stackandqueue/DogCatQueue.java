package top.irvingsoft.chengyun.stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Page 28
 * <p>
 * 用两个队列分别存储 Dog 和 Cat，在出队列前比较两个队列头部计数器的大小，小的出队列
 *
 * @author TimeChaser
 * @since 2021/8/8 15:12
 */
public class DogCatQueue {

    private final Queue<PetEnterQueue> catQueue;
    private final Queue<PetEnterQueue> dogQueue;
    private long count;

    public DogCatQueue() {
        this.dogQueue = new LinkedList<>();
        this.catQueue = new LinkedList<>();
        this.count = 0;
    }

    public static void main(String[] args) {

        DogCatQueue dogCatQueue = new DogCatQueue();
        System.out.println(dogCatQueue.isEmpty());
        System.out.println(dogCatQueue.isCatEmpty());
        System.out.println(dogCatQueue.isDogEmpty());
        dogCatQueue.add(new Dog());
        System.out.println(dogCatQueue.isDogEmpty());
        dogCatQueue.add(new Cat());
        System.out.println(dogCatQueue.isCatEmpty());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Dog());
        dogCatQueue.add(new Cat());
        System.out.println(dogCatQueue.poll().toString());
        System.out.println(dogCatQueue.pollCat().toString());
        System.out.println(dogCatQueue.pollCat().toString());
        System.out.println(dogCatQueue.poll().toString());
        System.out.println(dogCatQueue.poll().toString());
        System.out.println(dogCatQueue.isEmpty());
        System.out.println(dogCatQueue.isCatEmpty());
        System.out.println(dogCatQueue.isDogEmpty());
    }

    public void add(Pet pet) {
        if (pet.getPetType().equals("dog")) {
            this.dogQueue.add(new PetEnterQueue(pet, this.count++));
        } else if (pet.getPetType().equals("cat")) {
            this.catQueue.add(new PetEnterQueue(pet, this.count++));
        } else {
            throw new RuntimeException("Unknown Pet Type!");
        }
    }

    public boolean isCatEmpty() {
        return this.catQueue.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQueue.isEmpty();
    }

    public boolean isEmpty() {
        return this.isDogEmpty() && this.isCatEmpty();
    }

    public Pet poll() {

        if (this.isEmpty()) {
            throw new RuntimeException("Pet is Empty");
        }
        if (this.isDogEmpty()) {
            return this.catQueue.poll().getPet();
        }
        if (this.isCatEmpty()) {
            return this.dogQueue.poll().getPet();
        }

        return this.dogQueue.peek().getCount() < this.catQueue.peek().getCount() ?
               this.dogQueue.poll().getPet() :
               this.catQueue.poll().getPet();
    }

    public Cat pollCat() {

        if (this.isCatEmpty()) {
            throw new RuntimeException("Pet is Empty");
        }
        return (Cat) this.catQueue.poll().getPet();
    }

    public Dog pollDog() {

        if (this.isDogEmpty()) {
            throw new RuntimeException("Pet is Empty");
        }
        return (Dog) this.dogQueue.poll().getPet();
    }

}
