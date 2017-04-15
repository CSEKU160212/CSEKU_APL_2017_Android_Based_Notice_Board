<?php
require "connection.php";
$NoticeId=$_POST["NoticeId"];
$response = array();
$sql="Delete from notice WHERE `NoticeId` = '$NoticeId'";
$sqll="Delete from subscription WHERE `NoticeId` = '$NoticeId'";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_query($conn,$sql))
{
	$result = mysqli_query($conn,$sqll);
	$code = "Success";
	$message = "Delete successfully..";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
else
{
	$code = "delete failed";
	$message = "failed...";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
}
mysqli_close($conn);
?>