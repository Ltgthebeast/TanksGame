/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanksgame.Objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import sun.applet.Main;
import tanksgame.Engine.MainGame;

/**
 *
 *  two images 
 * one is the tank
 * one is the barrel
 * barrel angle is determined by the position of the mouse
 * 
 * @author LGarceau
 */
public class Player extends GameObject{

	public double canAngle = 0, decreaseHeight = 0, increaseWidth = 0;
	public BufferedImage can = MainGame.funct.getImageFromName("tankCan.png"),
			tank = MainGame.funct.getImageFromName("tank30.png");
	public boolean colliding = false;
	public Rectangle top, left, right, bottom;
	public Player(int x, int y, double velX, double velY, ID id, String image) {
		super(x, y, velX, velY, id, image);
	}

	@Override
	public void render(Graphics2D g) {
                g.setColor(new Color(210,180,140));
                g.fillRect((int)(this.x-(this.width)), (int)(this.y-((this.height))) , (int)(this.width*2), (int)(this.height*2));
		can = MainGame.funct.getScaledImage(MainGame.funct.getImageFromName("tankCan.png"), 33, 65);
		tank = MainGame.funct.getScaledImage(MainGame.funct.getImageFromName("tank.png"), 77, 100);
		double  xCord = MainGame.mouseX-MainGame.player.x,
				yCord = MainGame.mouseY-MainGame.player.y;
		canAngle = Math.atan(-xCord/yCord);
		if(yCord > 0){
			canAngle += Math.PI;
		}
		double xConstant = 22, yConstant = 5;
                drawArrow(g);
		g.drawImage(tank, (int)(x-tank.getWidth()/2), (int)y-tank.getHeight()/2, null);
//		g.rotate(canAngle, (int)(x-can.getWidth()/2)+xConstant, (int)y-can.getHeight()/2+yConstant);
                g.rotate(canAngle, this.getX(), this.getY()+yConstant);
		g.drawImage(can, (int)(x-tank.getWidth()/2)+22, (int)y-tank.getHeight()/2+12, null);
//		g.rotate(-canAngle, (int)(x-can.getWidth()/2)+xConstant, (int)y-can.getHeight()/2+yConstant);
                g.rotate(-canAngle, this.getX(), this.getY()+yConstant);
//		MainGame.funct.drawBounds(g, this);
		g.setColor(Color.green);
		updateRects();
                

	}
        
        public void drawArrow(Graphics2D g){
            int x = (int) MainGame.mouseX,
                y = (int) MainGame.mouseY;
//            double hyp = Math.sqrt((x*x)+(y*y));
            g.setColor(Color.cyan);
            g.drawLine(this.getX(), this.getY(), x, y);
            g.drawLine(x, y, x+10, y+10);
            g.drawLine(x, y, x-10, y-10);
            g.drawLine(x, y, x+10, y-10);
            g.drawLine(x, y, x-10, y+10);
            System.out.println("X: "+x);
            System.out.println("Y: "+y);
        }

	public String getIntersectedWall(){
		String wall = "";
		for(int i = 0; i < MainGame.handler.objs.size(); i++){
			GameObject temp = MainGame.handler.objs.get(i);
			if(temp.id == ID.Wall){
				if(collision(temp)){
					return temp.getImage();
				}
			}
		}
		return wall;
	}

	@Override
	public void tick() {
		decreaseHeight = 15-20*Math.cos(canAngle);
		increaseWidth = 0-20*Math.cos(canAngle-90);
//		System.out.println("angle:"+canAngle+"height:"+decreaseHeight);
//		System.out.println("angle:"+Math.toDegrees(canAngle)+"width:"+increaseWidth);

		updateRects();
		Point velVect = new Point();
		velVect.setLocation(velX, velY);
		for(int i = 0; i < MainGame.handler.objs.size(); i++){
			GameObject obj = MainGame.handler.objs.get(i);
			if(obj.getBounds() != null){
				if(obj.id == ID.Wall){
					if(collision(obj)){
						String[] direction = getDirection(obj);
						colliding = true;
						if(velVect.x != 0 && !direction[0].equals("none") && !direction[1].equals("none")){
							// can move
							if(direction.equals("bottom") && velVect.y >= 0){
								y+=velY;
							}
							if(direction.equals("top") && velVect.y <= 0){
								y+=velY;
							}
							if(direction.equals("right") && velVect.y >= 0){
								x+=velX;
							}
							if(direction.equals("left") && velVect.x <= 0){
								x+=velX;
							}
							return;
						}
						switch (direction[0]) {
						case "right":
							setX(x-5);
							checkCollision(obj);
							return;
						case "left":
							setX(x+5);
							checkCollision(obj);
							return;
						default:
							break;                                    
						}
						switch(direction[1]){
						case "bottom":
							setY(y-15);
							checkCollision(obj);
							return;
						case "top":
							setY(y+15);
							checkCollision(obj);
							return;
						default:
							break;
						}
					}
				}                  
			}                
		}
		x+=velX;
		y+=velY;       
	}

	public void checkCollision(GameObject obj){
		if(!collision(obj)){
			colliding = false;
		}  
	}
	
	public void updateRects(){
		top = new Rectangle(getBounds().x+10, getBounds().y, getBounds().width-20, 10);
		bottom = new Rectangle(getBounds().x+10, getBounds().y+getBounds().height-10, getBounds().width-20, 10);
		left = new Rectangle(getBounds().x, getBounds().y+7, 10, getBounds().height-20);
		right = new Rectangle(getBounds().x+getBounds().width-10, getBounds().y+7, 10, getBounds().height-20);
	}

	public String[] getDirection(GameObject obj){
		String[] direction = {"none","none"};
		/*
		 * quadrants of collision
		 *   1
		 * 2   3
		 *   4
		 */
		updateRects();
		if(top.intersects(obj.getBounds())){
			direction[1] = "top";
		}
		if(bottom.intersects(obj.getBounds())){
			direction[1] = "bottom";
		}
		if(left.intersects(obj.getBounds())){
			direction[0] = "left";
		}
		if(right.intersects(obj.getBounds())){
			direction[0] = "right";
		}
		return direction;
	}


	@Override
	public boolean collision(GameObject obj) {
		Rectangle thisRect = this.getBounds(),
				objRect = obj.getBounds();
		return thisRect.intersects(objRect);
	}

	@Override
	public Rectangle getBounds() {
		Rectangle r = new Rectangle((int)(this.x-(this.width/2)-increaseWidth), (int)(this.y-((this.height/2)-decreaseHeight)) , (int)(this.width+increaseWidth), (int)(this.height-decreaseHeight));
		return r;
	}



}
