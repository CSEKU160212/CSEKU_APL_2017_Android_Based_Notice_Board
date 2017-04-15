<?php
require "connection.php";

$UserId=$_POST["UserId"];

$sql="SELECT notice.Title,notice.Description,notice.Date,notice.NoticeType,notice.NoticeId FROM notice where notice.UserId like '$UserId' order by notice.Date DESC";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_array($result,MYSQLI_ASSOC))
	{
	$Title = $row["Title"];
	$Description=$row["Description"];
	$Date=$row["Date"];
	$Type=$row["NoticeType"];
	$NoticeId=$row["NoticeId"];
	array_push($response,array("Title"=>$Title,"Description"=>$Description,"Date"=>$Date,"NoticeType"=>$Type,"NoticeId"=>$NoticeId));
	}
        echo json_encode($response);
}
mysqli_close($conn);

?>