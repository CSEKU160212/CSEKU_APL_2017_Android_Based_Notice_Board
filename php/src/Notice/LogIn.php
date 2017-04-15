<?php
require "connection.php";
$Email =$_POST["Email"];
$Password =$_POST["Password"];
$sql="SELECT UserId,Email,Password,Dicipline,Batch,University FROM user where Email like '$Email' and Password like '$Password' ";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	$row = mysqli_fetch_row($result);
	$UserId=$row[0];
	$Email = $row[1];
	$Dicipline=$row[3];
	$Batch=$row[4];
	$University=$row[5];
	$code = "Success";
	array_push($response,array("code"=>$code,"UserId"=>$UserId,"Email"=>$Email,"Dicipline"=>$Dicipline,"Batch"=>$Batch,"University"=>$University));
        echo json_encode($response);
}
else
{
	$code = "Login_failed";
	$message = "User not found...Please try again...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
mysqli_close($conn);

?>