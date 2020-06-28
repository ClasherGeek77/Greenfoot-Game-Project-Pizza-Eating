import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    private GreenfootImage robotimage1= new GreenfootImage("man01.png");
    private GreenfootImage robotimage2= new GreenfootImage("man02.png");
    private GreenfootImage gameoverimage= new GreenfootImage("gameover.png");
    private int animatecounter;
    private int lives = 3; //store number of lives
    private int score; //store the current score
    private int pizzaEaten; //store the number of pizza eaten
    private int timer; 
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        robotMovement();
        detectWallCollision();
        detectBlockCollision();
        detectHome();
        eatPizza();
        updateTimer();
    }    
    private void robotMovement()
    {
        if (Greenfoot.isKeyDown("right"))
        {
            setLocation(getX()+3,getY());
            animate();
        }
        if (Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-3,getY());
            animate();
        }
        if (Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+3);
            animate();
        }
        if (Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-3);
            animate();
        } 
    }
    public void detectWallCollision() 
    {
        if (isTouching(Wall.class)) {
            Greenfoot.playSound("hurt.wav");
            setLocation(27,38);
            removeLife();
        }
    }
    public void detectBlockCollision() 
    {
        if (isTouching(Block.class)) {
            Greenfoot.playSound("hurt.wav");
            setLocation(27,38);
            removeLife();
        }
    }
    public void detectHome()
    {
        if (isTouching(Home.class)) {
            Greenfoot.playSound("yipee.wav");
            setLocation(27,38);
            increaseScore();
            pizzaEaten = 0;
            
            RobotWorld myworld = (RobotWorld)getWorld();
            myworld.increaseLevel();
            timer = 1000;
        }
    }
    public void eatPizza()
    {
        if (isTouching(Pizza.class)) {
            Greenfoot.playSound("eat.wav");
            removeTouching(Pizza.class);
            pizzaEaten++;
            timer = timer + 200;
        }
    }
    public void animate()
    {
         animatecounter++;
         if (animatecounter > 5) {
             animatecounter = 0;
         if (getImage() == robotimage1) {
             setImage(robotimage2);
            }
            else {
                setImage(robotimage1);
            }
        }
    }
    public void removeLife() 
    {
         lives--;
         testEndGame();
         showStatus();
    }
    public void testEndGame()
    {
        if (lives < 0) {
            setImage(gameoverimage);
            Greenfoot.stop();
        }
    }
    public void increaseScore()
    {
        score++;
        showStatus();
    }
    public void showStatus()
    {
        getWorld().showText("Lives : "+lives, 70,540);
        getWorld().showText("Score : "+score, 70,560);
    }
    public Robot()
    {
        timer = 1000;
    }
    public void updateTimer()
    {
        timer--;
        getWorld().showText("Time Left : "+timer, 83,520);
        if (timer < 1) {
            removeLife();
        }
    }
}
