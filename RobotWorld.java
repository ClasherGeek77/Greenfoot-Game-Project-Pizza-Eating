import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RobotWorld here.
 * 
 * @author (Teddy Lioner 535180014) 
 * @version (3/14/2019)
 * HOW TO PLAY
 * Game ini memberikan kontrol movement Robot kepada player
 * Player harus mengontrol Robot agar sampai ke Home
 * Jika Player berhasil membawa Robot ke Home,
 * maka game akan mengalami kenaikan level kesulitan.
 * 
 * Robot memiliki 3 nyawa.
 * 
 * Robot tidak boleh menyentuh Wall atau Block yang berputar
 * jika Robot menyentuh Wall atau Blockmaka Robot akan kehilangan satu nyawa.
 * Jika Robot kehilangan semua nyawa, maka Game Over.
 * 
 * Ada batas waktu bagi Robot untuk mencapai Home,
 * jika batas waktu habis maka Game Over.
 * 
 * Player memenangkan permainan bila berhasil melewati level 2.
 */
public class RobotWorld extends World
{
    int currentMaxTurnSpeed = 2;
    int currentLevel = 1;
    /**
     * Constructor for objects of class RobotWorld.
     * 
     */
    public RobotWorld()
    {    
        // Create a new world with 800x600 cells with a cell size of 1x1 pixels.
        super(800, 600, 1);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Robot robot = new Robot();
        addObject(robot,27,38);
        Pizza pizza = new Pizza();
        addObject(pizza,407,23);
        Pizza pizza2 = new Pizza();
        addObject(pizza2,730,52);
        Pizza pizza3 = new Pizza();
        addObject(pizza3,198,307);
        Pizza pizza4 = new Pizza();
        addObject(pizza4,687,304);
        Home home = new Home();
        addObject(home,744,549);
        Wall wall = new Wall();
        addObject(wall,53,144);
        Wall wall2 = new Wall();
        addObject(wall2,160,144);
        Wall wall3 = new Wall();
        addObject(wall3,266,144);
        Wall wall4 = new Wall();
        addObject(wall4,745,143);
        Wall wall5 = new Wall();
        addObject(wall5,700,143);
        Wall wall6 = new Wall();
        addObject(wall6,600,143);
        Block block = new Block(2);//Block(2)untuk constructor maxspeed
        addObject(block,433,136);
        Pizza pizza5 = new Pizza();
        addObject(pizza5,410,535);
        home.setLocation(749,542);
        ScorePanel scorePanel = new ScorePanel();
        addObject(scorePanel,86,545);
    }
    public void setUpLevel()
    {
        if (currentLevel == 2) {
            currentMaxTurnSpeed++;
            addObject(new Block(currentMaxTurnSpeed),433,136);
            Pizza pizza = new Pizza();
            addObject(pizza,407,23);
            Pizza pizza2 = new Pizza();
            addObject(pizza2,730,52);
            Pizza pizza3 = new Pizza();
            addObject(pizza3,198,307);
            Pizza pizza4 = new Pizza();
            addObject(pizza4,687,304);
            Pizza pizza5 = new Pizza();
            addObject(pizza5,730,304);
        }
        else
        {
            showText("YOU WIN!", 400,300);
            Greenfoot.stop();
        }
    }
    public void increaseLevel()
    {
        currentLevel++;
        setUpLevel();
    }
}