<?php
require "connection.php";
$Title =$_POST["Title"];
$Description=$_POST["Description"];
$Type=$_POST["NoticeType"];
$UserId=$_POST["UserId"];

$response = array();
	$sql="INSERT INTO `notice` (`NoticeId`, `Title`, `Description`, `NoticeType`, `UserID`, `Date`) VALUES (NULL, '$Title', '$Description', '$Type', '$UserId', CURRENT_TIMESTAMP)";
	$result = mysqli_query($conn,$sql);
	
	if(!$result)
	{
	$code = "Failed";
	$message = "Server not response";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
	else
	{
	$code = "Success";
	$message = "Thank you for publishing. Now....,";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
mysqli_close($conn);
?>