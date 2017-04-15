<?php
require "connection.php";

$Batch =$_POST["Batch"];
$UserId=$_POST["UserId"];

$response = array();
	$sql="Select Batch,UserId from channel where UserId like '$UserId' and Batch like '$Batch'";
	$result = mysqli_query($conn,$sql);
	if(mysqli_num_rows($result)>0)
	{
	$code = "failed";
	$message = "You are alredy subscribe this batch";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
	else
	{
	$sql="INSERT INTO `channel` (`Id`, `Batch`, `UserId`) VALUES (NULL, '$Batch', '$UserId')";
	$result = mysqli_query($conn,$sql);
	$code = "success";
	$message = "welcome to new subscribe";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
mysqli_close($conn);
?>