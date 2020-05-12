# update usr set password = encode(password, 'mykeystring');
# update usr set password = if(username != 'admin', MD5(password), password);