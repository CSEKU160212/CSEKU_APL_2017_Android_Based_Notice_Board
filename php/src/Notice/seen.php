<?php
require "connection.php";
$Dicipline =$_POST["Dicipline"];
$Batch =$_POST["Batch"];
$University =$_POST["University"];
$UserId=$_POST["UserId"];

$sql="SELECT notice.Title,notice.Description,user.Batch,user.FirstName,notice.Date,notice.NoticeType,notice.UserId,notice.NoticeId,user.UserId,user.Dicipline,user.University,subscription.UserId,subscription.Seen,subscription.NoticeId FROM notice,user,subscription
where notice.UserId like user.UserId and user.Dicipline like '$Dicipline' and (user.Batch like '$Batch' or (user.Batch IN(SELECT Batch from channel where UserId like '$UserId') and notice.NoticeType like 'Only for Subscriber')or notice.NoticeType like 'For all') and user.University like '$University' 
and subscription.NoticeId like notice.NoticeId and subscription.UserId like '$UserId' and subscription.Seen like '1' order by notice.Date DESC";
$result = mysqli_query($conn,$sql);
$response=array();
if(mysqli_num_rows($result)>0)
{
	while($row = mysqli_fetch_array($result,MYSQLI_ASSOC))
	{
	$Title = $row["Title"];
	$Description=$row["Description"];
	$Batch = $row["Batch"];
	$FirstName=$row["FirstName"];
	$Date=$row["Date"];
	$Type=$row["NoticeType"];
	array_push($response,array("Title"=>$Title,"Description"=>$Description,"Batch"=>$Batch,"FirstName"=>$FirstName,"Date"=>$Date,"NoticeType"=>$Type));
	}
        echo json_encode($response);
}
mysqli_close($conn);

?>