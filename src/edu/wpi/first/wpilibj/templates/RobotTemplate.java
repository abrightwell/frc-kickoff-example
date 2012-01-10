/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SimpleRobot;
import edu.wpi.first.wpilibj.SpeedController;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends SimpleRobot {
    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomous() {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void operatorControl() {
        Joystick joystick = new Joystick(1);
        
        SpeedController leftFront = new Jaguar(4, 1);
        SpeedController leftRear = new Jaguar(4, 3);
        SpeedController rightFront = new Jaguar(4, 2);
        SpeedController rightRear = new Jaguar(4, 4);
        
         RobotDrive drive = new RobotDrive(leftFront, leftRear, rightFront, rightRear);
         drive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
         drive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
         
         while (isOperatorControl() && isEnabled()) {
             double x = joystick.getX();
             double y = joystick.getY();
             double rotation = 0.0;
             
             if (joystick.getRawButton(5) && joystick.getRawButton(6)) {
                rotation = 0.0;
            } else if (joystick.getRawButton(5)) {
                rotation = -0.75;
            } else if (joystick.getRawButton(6)) {
                rotation = 0.75;
            }

            drive.mecanumDrive_Cartesian(x, y, rotation, 0);
             
         }
    }
}
