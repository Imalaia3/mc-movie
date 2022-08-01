import io
import pygame as pg
import requests as re


try:
    # Python2
    from urllib2 import urlopen
except ImportError:
    # Python3
    from urllib.request import urlopen


k_space = False

# initialize pygame
pg.init()

image_url = "http://127.0.0.1:5000/img"

image_str = urlopen(image_url).read()
image_file = io.BytesIO(image_str)


white = (255, 255, 0)


screen = pg.display.set_mode((600,400),  pg.RESIZABLE )
screen.fill(white)


image = pg.image.load(image_file)


screen.blit(image, (20, 20))

# nothing gets displayed until one updates the screen
pg.display.flip()

clock = pg.time.Clock()



v=1
k_space=True
while True:
	clock.tick(10)
	screen.fill(white)
	image_str = urlopen(image_url).read()
	image_file = io.BytesIO(image_str)

	image = pg.image.load(image_file)




	screen.blit(image, (20, 20))

	if k_space:
		re.get("http://127.0.0.1:5000/tick")
	for event in pg.event.get():
		if event.type == pg.QUIT:
			pg.quit()
			raise SystemExit

		if event.type == pg.KEYDOWN:
			if event.key == pg.K_SPACE:
				k_space = True
				#re.get("http://127.0.0.1:5000/tick")
			

		if event.type == pg.KEYUP:
			if event.key == pg.K_SPACE:
				k_space = False
				



	pg.display.flip()
	
	



