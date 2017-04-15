<?php
require "connection.php";

$Dicipline =$_POST["Dicipline"];
$Batch =$_POST["Batch"];
$University =$_POST["University"];
$UserId=$_POST["UserId"];

$sql="SELECT notice.NoticeId,notice.Title,notice.Description,user.Batch,user.FirstName,notice.Date,notice.NoticeType,notice.UserId,user.UserId,user.Dicipline,user.University FROM notice,user
where (notice.UserId like user.UserId and user.Dicipline like '$Dicipline' and (user.Batch like '$Batch' or (user.Batch IN(SELECT Batch from channel where UserId like '$UserId') and notice.NoticeType like 'Only for Subscriber')or notice.NoticeType like 'For all')and user.University like '$University')
and notice.NoticeId NOT IN(SELECT NoticeId from subscription where UserId like '$UserId')order by notice.Date DESC";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_array($result,MYSQLI_ASSOC))
	{
	$NoticeId=$row["NoticeId"];
	$Title = $row["Title"];
	$Description=$row["Description"];
	$Batch = $row["Batch"];
	$FirstName=$row["FirstName"];
	$Date=$row["Date"];
	$Type=$row["NoticeType"];
	array_push($response,array("Title"=>$Title,"Description"=>$Description,"Batch"=>$Batch,"FirstName"=>$FirstName,"NoticeId"=>$NoticeId,"Date"=>$Date,"NoticeType"=>$Type));
	}
        echo json_encode($response);
}
mysqli_close($conn);

?>