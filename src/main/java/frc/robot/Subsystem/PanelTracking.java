/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.Subsystem;


//import org.json.JSONObject;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;


/**
 * Add your docs here.
 */
public class PanelTracking extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
//   private double frameXMiddle = 320;
//   private double frameYMiddle = 240;
//   private double kPvision = 0.006;
//   private double kIvision = 0.0025;
//   private double kDvision = 0.001;
  
  public double outputX = 0;
  public double errorX = 0;
  public double errorX_prev = 0;
  public double errorX_last = 0;
  public double visionOutput = 0;
  public double maxRPM = 5600;

//public double visionKp = 0.002;
  public double visionKp = 0.01;


  public DigitalOutput LED = RobotMap.LED; 



  public void DataAcquire(){
/*
    DatagramSocket dsocket = null;
    try{
        dsocket = new DatagramSocket(5800);
        byte[] buffer = new byte[256];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        dsocket.receive(packet);
        String msg = new String(buffer, buffer.length);

       //System.out.println(packet.getAddress() + ":" + msg);
        

        JSONObject msgJson = new JSONObject(msg);
      //  System.out.println(msgJson);

        boolean visionJudge = msgJson.getBoolean("target");
        int valueX = msgJson.getInt("Coordinate_x");
        int valueY = msgJson.getInt("Coordinate_y");
        System.out.print(visionJudge + ", ");
        System.out.println(errorX + ", " );
    //    System.out.println(valueY + ", " );

        if(visionJudge){

            //double errorX = frameXMiddle - valueX;
            //double speedRotate = visionKp*errorX;


          //  Robot.driveBase.arcadeDrive_PercentOutput_Original(0, limit(speedRotate));
        }

        //boolean visionJudge = msgJson.getBoolean('target');

    }catch (SocketException e) { 
        e.printStackTrace(); 
    } catch (IOException e) { 
        e.printStackTrace(); 
    } finally { 
        dsocket.close(); 
    }       

  */  
  }

  @Override
  protected void initDefaultCommand() {
      
  }

  @Override
  public void periodic() {
  //    DataAcquire();
  }



}
