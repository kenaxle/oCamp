sed -i "/Deny from All/d" /etc/httpd/conf.d/wordpress.conf 
sed -i "s/Require local/Require all granted/" /etc/httpd/conf.d/wordpress.conf 
sed -i s/wordpress_db/ /etc/wordpress/wp-config.php 
sed -i s/dbUser/user/ /etc/wordpress/wp-config.php 
sed -i s/pass@w0rd/ /etc/wordpress/wp-config.php 
systemctl restart httpd.service