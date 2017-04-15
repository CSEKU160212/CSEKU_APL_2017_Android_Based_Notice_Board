<?php
require "connection.php";

$NoticeId=$_POST["NoticeId"];
$UserId =$_POST["UserId"];

$response = array();
	$sql="INSERT INTO `subscription` (`Id`, `UserId`, `NoticeId`, `Seen`) VALUES (NULL, '$UserId', '$NoticeId', '1')";
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
	$message = "Thank you for publishing..";
	array_push($response,array("code"=>$code,"message"=>$message));
	echo json_encode($response);
	}
mysqli_close($conn);
?>
