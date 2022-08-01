"""
Program MUST have read/write permissions
and have some hard drive space available.

The Server runs on port 5000 (which is also hardcoded in the plugin.)
The video must be named vid.mp4.
While the mp4 format isn't something specific the filename MUST be vid.mp4
"""


from flask import Flask,request,send_file
import cv2
import logging

app = Flask(__name__)
log = logging.getLogger('werkzeug')
log.setLevel(logging.ERROR)


global FRAME_COUNT
FRAME_COUNT = 0
CURR_FRAME_NAME = "sv.jpg"
vidcap = cv2.VideoCapture('vid.mp4')

def update_frame():
	global FRAME_COUNT
	count = 0
	done=False
	while not done:
		success,image = vidcap.read()
		
		if not success:
			break

		if count==FRAME_COUNT:
			print("Reached New Frame. #"+str(FRAME_COUNT)+" Saving...")
			cv2.imwrite(CURR_FRAME_NAME,image)
			done=True

			
		count+=1
	FRAME_COUNT +=1



#update_frame()

@app.route("/img")
def return_image():
	#give Image
	return send_file(CURR_FRAME_NAME,mimetype='image/jpg')

@app.route("/tick")
def tick_app():
	
	try:
		update_frame()
		return 'OK'
	except Exception as e:
		print("FAILED! At: tick_app() ",e)



app.run(port=5000)
