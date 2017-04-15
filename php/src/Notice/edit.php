<?php
require "connection.php";

$Title =$_POST["Title"];
$Description=$_POST["Description"];
$Type=$_POST["NoticeType"];
$NoticeId=$_POST["NoticeId"];

$response = array();
	$sql="UPDATE `notice` SET `Title` = '$Title', `Description` = '$Description', `NoticeType` = '$Type' WHERE `notice`.`NoticeId` = '$NoticeId'";
	
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
	$message = "Thank you for editing. Now....,";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
mysqli_close($conn);
?>