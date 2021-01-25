package Lesson05;

public class Animal {
    protected String name;
    protected int run;
    protected int swim;
    protected double jump;

    public Animal (String name, int run, int swim, double jump) {
        this.name = name;
        this.run = run;
        this.swim = swim;
        this.jump = jump;
    }

    public void running(int runDist){
        if (run >= runDist)
        System.out.println(name + "пробежал");
        else System.out.println(name + "не смог");
    }

    public void swimming(int swimDist){
        if (swim >= swimDist)
            System.out.println(name + "проплыл");
        else System.out.println(name + "не поплыл");
    }

    public void jumping(int jumpDist){
        if (jump >= jumpDist)
            System.out.println(name + "перепрыгнул");
        else System.out.println(name + "не смог");
    }
}
