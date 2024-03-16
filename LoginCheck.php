<?php
// Database configuration
$host = 'localhost'; // or your database host
$dbname = 'FinanceAnalyzer'; // your database name
$username = 'root'; // your database username
$password = 'newpassword'; // your database password

// Data Source Name (DSN)
$dsn = "mysql:host=$host;dbname=$dbname";

try {
    // Create a PDO instance (connect to the database)
    $pdo = new PDO($dsn, $username, $password);
    // Set the PDO error mode to exception
    $pdo->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);

    // Get username and password from POST request
    $inputUsername = isset($_POST['username']) ? $_POST['username'] : '';
    $inputPassword = isset($_POST['password']) ? $_POST['password'] : '';

    // SQL query with placeholders for parameters
    $sql = "SELECT COUNT(*) FROM users WHERE username = :username AND password = :password";

    // Prepare statement
    $stmt = $pdo->prepare($sql);

    // Bind parameters
    $stmt->bindParam(':username', $inputUsername, PDO::PARAM_STR);
    $stmt->bindParam(':password', $inputPassword, PDO::PARAM_STR);

    // Execute the query
    $stmt->execute();

    // Check if user exists
    if ($stmt->fetchColumn() > 0) {
        echo "1"; // User found
    } else {
        echo "0"; // No user found
    }
} catch (PDOException $e) {
    // Handle database connection error
    echo "Connection failed: " . $e->getMessage();
}

?>
