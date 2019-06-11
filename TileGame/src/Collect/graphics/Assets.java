package Collect.graphics;

import java.awt.image.BufferedImage;

public class Assets 
{
	private static final int width = 32, height = 32;
	public static BufferedImage dirt, grass, stone, stone2, tree;
	public static BufferedImage wood;
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage[] opponent_down, opponent_up, opponent_left, opponent_right;
	public static BufferedImage[] btn_start;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/ObyZadzialao3.png"));
		
		int zmiana = Collect.menu.SettingsView.postac;
		int tp = Collect.menu.SettingsView.mapa;
		
			player_down = new BufferedImage[2];
			player_up = new BufferedImage[2];
			player_right = new BufferedImage[2];
			player_left = new BufferedImage[2];
		 
			player_down[0] = sheet.crop(width*4, zmiana*(2*height), width, height);
			player_down[1] = sheet.crop(width*5, zmiana*(2*height), width, height);
		 
			player_up[0] = sheet.crop(width*6, zmiana*(2*height), width, height);
			player_up[1] = sheet.crop(width*7, zmiana*(2*height), width, height);

			player_right[0] = sheet.crop(width*4, height+zmiana*(2*height), width, height);
			player_right[1] = sheet.crop(width*5, height+zmiana*(2*height), width, height);
		 
			player_left[0] = sheet.crop(width*6, height+zmiana*(2*height), width, height);
			player_left[1] = sheet.crop(width*7, height+zmiana*(2*height), width, height);
		 
			opponent_down = new BufferedImage[2];
			opponent_up = new BufferedImage[2];
			opponent_right = new BufferedImage[2];
			opponent_left = new BufferedImage[2];
		 
			opponent_down[0] = sheet.crop(width*4, height*2-zmiana*(2*height), width, height);
			opponent_down[1] = sheet.crop(width*5, height*2-zmiana*(2*height), width, height);
		 
			opponent_up[0] = sheet.crop(width*6, height*2-zmiana*(2*height), width, height);
			opponent_up[1] = sheet.crop(width*7, height*2-zmiana*(2*height), width, height);

			opponent_right[0] = sheet.crop(width*4, height*3-zmiana*(2*height), width, height);
			opponent_right[1] = sheet.crop(width*5, height*3-zmiana*(2*height), width, height);
		 
			opponent_left[0] = sheet.crop(width*6, height*3-zmiana*(2*height), width, height);
			opponent_left[1] = sheet.crop(width*7, height*3-zmiana*(2*height), width, height);
		 
			dirt = sheet.crop(width*3-tp*width, height +tp*(3*height), width, height);
			grass = sheet.crop(width*2, height +tp*(2*height), width, height);
			stone = sheet.crop(0+tp*(2*width), 0 +tp*(5*height), width, height);
			stone2 = sheet.crop(width*3, 0, width, height);
			tree = sheet.crop(width-zmiana*height, height+zmiana*height, width, height);
			
			
			
			

	}
}
