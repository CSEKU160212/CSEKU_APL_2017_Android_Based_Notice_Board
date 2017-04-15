<?php
require "connection.php";

$Batch =$_POST["Batch"];
$UserId=$_POST["UserId"];

$response = array();

$sql="Delete from channel where UserId like '$UserId' and Batch like '$Batch'";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_query($conn,$sql))
{
	$code = "Success";
	$message = "Unsubscribe successfully..";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
else
{
	$code = "delete failed";
	$message = "failed...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
mysqli_close($conn);
?>