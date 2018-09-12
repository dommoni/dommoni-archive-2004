<?
if ($_POST)
{
	$firstname = $_POST['firstname'];
	$lastname = $_POST['lastname'];
	$company = $_POST['company'];
	$companyaddress = $_POST['companyaddress'];
	$city = $_POST['city'];
	$stateprovince = $_POST['stateprovince'];
	$zip = $_POST['zip'];
	$email = $_POST['email'];
	$phonenumber = $_POST['phonenumber'];

	$message = "firstname: $firstname\n";
	$message .= "lastname: $lastname\n";
	$message .= "company: $company\n";
	$message .= "Address: $companyaddress\n";
	$message .= "City: $city\n";
	$message .= "state: $stateprovince\n";
	$message .= "zip: $zip\n";
	$message .= "email: $email\n";
	$message .= "phonenumber: $phonenumber\n";
    mail("brian@dommoni.com", "TRIAL-SIGNUP - $company", $message);

    header("Location: http://www.dommoni.com/roundtable_signupsuccess.html"); 
    exit;

}
?>
