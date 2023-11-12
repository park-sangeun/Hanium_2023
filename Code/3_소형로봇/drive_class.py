import time
import busio

from board import SCL, SDA
from adafruit_pca9685 import PCA9685
from adafruit_motor import motor


class drivingclass:

    def __init__(self):
        print("init.............")
        self.i2c = busio.I2C(SCL, SDA)

        self.pca = PCA9685(self.i2c, address=0x40)
        self.pca.frequency = 100

        self.pca.channels[12].duty_cycle = 0xFFFF
        self.pca.channels[6].duty_cycle = 0xFFFF
        #self.pca.channels[15].duty_cycle = 0xFFFF
        #self.pca.channels[10].duty_cycle = 0xFFFF

        self.motor1 = motor.DCMotor(self.pca.channels[0], self.pca.channels[8]) #
        self.motor2 = motor.DCMotor(self.pca.channels[1], self.pca.channels[2])
        print("init.............finish")

    def goForward(self, speed):
        print(self)
        self.motor1.throttle = speed
        self.motor2.throttle = speed
        
        time.sleep(0.5)

    def goBackward(self, speed):
        self.motor1.throttle = -speed
        self.motor2.throttle = -speed
       
        time.sleep(1)

    def goRight(self, speed):
        self.motor1.throttle = -speed
        self.motor2.throttle = speed
        time.sleep(1)

    def goLeft(self, speed):
        self.motor1.throttle = speed
        self.motor2.throttle = -speed
        time.sleep(1)


    def turnRight(self, speed):
        self.motor1.throttle = speed
        self.motor2.throttle = -speed
        time.sleep(1)

    def turnLeft(self, speed):
        self.motor1.throttle = -speed
        self.motor2.throttle = speed
        time.sleep(1)

    def stop(self):
        self.motor1.throttle = 0
        self.motor2.throttle = 0
        time.sleep(1)
        
















