class DiningPhilosophers {
    private final ReentrantLock lock = new ReentrantLock();

    public void wantsToEat(
            int philosopher,
            Runnable pickLeftFork,
            Runnable pickRightFork,
            Runnable eat,
            Runnable putLeftFork,
            Runnable putRightFork) {

        lock.lock();
        try {
            pickLeftFork.run();
            pickRightFork.run();
            eat.run();
            putRightFork.run();
            putLeftFork.run();
        } finally {
            lock.unlock();
        }
    }
}