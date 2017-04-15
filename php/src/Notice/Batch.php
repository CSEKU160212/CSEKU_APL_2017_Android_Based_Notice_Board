<?php
require "connection.php";

$UserId=$_POST["UserId"];

$sql="Select Batch from channel where UserId like '$UserId'";

$result=mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row=mysqli_fetch_array($result,MYSQLI_NUM))
	{
		$Batch=$row[0];
		array_push($response,array("Batch"=>$Batch));
	}
	echo json_encode($response);
}
mysqli_close($conn);
?>