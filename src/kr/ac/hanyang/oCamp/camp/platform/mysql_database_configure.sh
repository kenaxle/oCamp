# Setup MySQL root password and create user 
cat << EOF | mysql -u root --password=pass@w0rd 
CREATE DATABASE wordpress_db; 
GRANT ALL PRIVILEGES ON wordpress_db.* TO "dbUser"@"localhost" 
IDENTIFIED BY "pass@w0rd"; 
FLUSH PRIVILEGES; 
EXIT 
EOF