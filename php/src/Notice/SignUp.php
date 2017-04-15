<?php
require "connection.php";
$FirstName =$_POST["FirstName"];
$LastName=$_POST["LastName"];
$Email=$_POST["Email"];
$Password=$_POST["Password"];
$Dicipline=$_POST["Dicipline"];
$Batch=$_POST["Batch"];
$University=$_POST["University"];

$sql="SELECT Email,Password FROM user where Email like '$Email' and Password like '$Password' ";
$result = mysqli_query($conn,$sql);
$response = array();
if(mysqli_num_rows($result)>0)
{
	$code = "Reg_failed";
	$message = "User already exist.....";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);

}
else
{
	$sql="INSERT INTO `user` (`FirstName`, `LastName`, `Email`, `Password`, `Dicipline`, `Batch`, `University`) VALUES ('$FirstName', '$LastName', '$Email', '$Password','$Dicipline', '$Batch', '$University')";
	$result = mysqli_query($conn,$sql);
	$code = "Success";
	$message = "Thank you for registering with us. Now....";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
mysqli_close($conn);
?>