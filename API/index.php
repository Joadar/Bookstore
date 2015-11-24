<?php
    require 'flight/Flight.php';

    /**
     * DATABASE CONNECTION
     */

    $dbname = "bookstore"; // database name
    $dbuser = "root"; // database user
    $dbpwd = "root"; // database password

    $connection = new PDO("mysql:host=localhost;dbname=$dbname", $dbuser, $dbpwd);
    $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
    $connection->setAttribute(PDO::ATTR_EMULATE_PREPARES, false);


    /**
     * USERS
     */

    // get all users - OK
    Flight::route("GET /users", function() use($connection){

        $result = $connection->prepare("SELECT id, username, email, sexe, active, admin FROM users");
        $result->execute();

        $return = $result->fetchAll(PDO::FETCH_CLASS);

        Flight::json($return);

    });

    // get user by id
    Flight::route("GET /users/@user_id", function($user_id) use($connection){

        $result = $connection->prepare("SELECT id, username, email, sexe, active, admin FROM users WHERE id = :user_id");
        $result->execute(
            array(
                ":user_id" => $user_id
            )
        );

        $return = $result->fetch(PDO::FETCH_ASSOC);
        if($return == false){
            $return = array(
                "success" => false,
                "message" => "This user doesn't exist"
            );
        }

        Flight::json($return);

    });

    // get comments from user
    Flight::route("GET /users/@user_id/comments", function($user_id) use($connection){

        $result = $connection->prepare("SELECT * FROM comments WHERE user_id = :user_id");
        $result->execute(
            array(
                ":user_id" => $user_id
            )
        );

        $return = $result->fetchAll(PDO::FETCH_ASSOC);
        if(empty($return)){
            $return = array(
                "success" => false,
                "message" => "This user have not posted comments yet"
            );
        }

        Flight::json($return);

    });

    // add new user
    Flight::route("POST /users", function() use($connection){
        $result = $connection->prepare("INSERT INTO users(username, password, email, sexe) VALUES(:username, :password, :email, :sexe)");
        $result->execute(
            array(
                ":username"     => Flight::request()->data->username,
                ":password"     => sha1(md5(Flight::request()->data->password)),
                ":email"        => Flight::request()->data->email,
                ":sexe"         => Flight::request()->data->sexe
            )
        );

        $status = false;
        $message = "Impossible to add this user";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "User added";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });

    // login user
    Flight::route("POST /users/login", function() use($connection){

        $result = $connection->prepare("SELECT id FROM users WHERE username = :username AND password = :password");
        $result->execute(
            array(
                ":username" => Flight::request()->data->username,
                ":password" => sha1(md5(Flight::request()->data->password)),
            )
        );

        $return = $result->fetch(PDO::FETCH_ASSOC);
        if($return){
            $return = array(
                "success" => true,
                "message" => "Login successful"
            );
        } else {
            $return = array(
                "success" => false,
                "message" => "Can't login"
            );
        }

        Flight::json($return);

    });

    // update user (own account)
    // TODO: add token to user
    /* Flight::route("PUT /users/@user_id?token=@user_token", function($user_id, $user_token) use($connection){

        $result = $connection->prepare("UPDATE users SET username = :username, password = :password WHERE id = :user_id AND token =:user_token");
        $result->execute(
            array(
                ":username" => Flight::request()->data->username,
                ":username" => Flight::request()->data->password,
                ":user_id" => $user_id,
                ":user_token" => $user_token
            )
        );

        $status = false;
        $message = "Impossible to update this user";
        if($result->rowCount() == 1){
            $status = true;
            $message = "User updated";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });*/


    /**
     * AUTHORS - OK
     */

    // get all authors
    Flight::route("GET /authors", function() use($connection){

        $result = $connection->prepare("SELECT * FROM authors");
        $result->execute();

        $return = $result->fetchAll(PDO::FETCH_CLASS);
        Flight::json($return); // return array of objects

    });

    // get author by id
    Flight::route("GET /authors/@author_id", function($author_id) use($connection){

        $result = $connection->prepare("SELECT * FROM authors WHERE id = :author_id");
        $result->execute(
            array(
                ':author_id' => $author_id
            )
        );

        $return = $result->fetch(PDO::FETCH_ASSOC);
        if($return == false) {
            $return = array(
                "success" => false,
                "message" => "Author don't exist"
            );
        }

        Flight::json($return);

    });

    // get all author's books
    Flight::route("GET /authors/@author_id/books", function($author_id) use($connection){

        $result = $connection->prepare("SELECT * FROM books WHERE author_id = :author_id");
        $result->execute(
            array(
                ":author_id" => $author_id
            )
        );

        $return = $result->fetchAll(PDO::FETCH_CLASS);
        if(empty($return)) {
            $return = array(
                "success" => false,
                "message" => "No books for this author"
            );
        }

        Flight::json($return);

    });

    // add a new book
    Flight::route("POST /authors/@author_id/books", function($author_id) use($connection){

        $result = $connection->prepare("INSERT INTO books(title, author_id, description, editor, collection, pages, published, genre, language, image) VALUES (:title, :author_id, :description, :editor, :collection, :pages, :published, :genre, :language, :image)");
        $result->execute(
            array(
                ":title"        => Flight::request()->data->title,
                ":author_id"    => $author_id,
                ":description"  => Flight::request()->data->description,
                ":editor"       => Flight::request()->data->editor,
                ":collection"   => Flight::request()->data->collection,
                ":pages"        => Flight::request()->data->pages,
                ":published"    => Flight::request()->data->published,
                ":genre"        => Flight::request()->data->genre,
                ":language"     => Flight::request()->data->language,
                ":image"        => Flight::request()->data->image
            )
        );

        $status = false;
        $message = "Impossible to add this author";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Author added";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });

    // add a new author
    Flight::route("POST /authors", function() use($connection){

        $result = $connection->prepare("INSERT INTO authors(firstname, lastname, biography) VALUES (:firstname, :lastname, :biography)");
        $result->execute(
            array(
                ':firstname'    => Flight::request()->data->firstname,
                ':lastname'     => Flight::request()->data->lastname,
                ':biography'    => Flight::request()->data->biography
            )
        );

        $status = false;
        $message = "Impossible to add this author";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Author added";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });

    // update biography author by id
    Flight::route("PUT /authors/@author_id", function($author_id) use($connection){

        $result = $connection->prepare("UPDATE authors SET biography = :biography WHERE id = :author_id");
        $result->execute(
            array(
                ':biography'    => Flight::request()->data->biography,
                ':author_id'    => $author_id
            )
        );

        $status = false;
        $message = "Impossible to update the author";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Author updated";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });

    // remove author by id
    Flight::route("DELETE /authors/@author_id", function($author_id) use($connection){
        $result = $connection->prepare("DELETE FROM authors WHERE id = :author_id");
        $result->execute(
            array(
                ":author_id" => $author_id
            )
        );

        $status = false;
        $message = "This author don't exist or an error emerged";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Author removed";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });


    /**
     * BOOKS - OK
     */

    // get all books
    Flight::route("GET /books", function() use($connection){

        $result = $connection->prepare("SELECT * FROM books");
        $result->execute();

        $return = $result->fetchAll(PDO::FETCH_CLASS);
        Flight::json($return); // return array of objects

    });

    // get book by id
    Flight::route("GET /books/@book_id", function($book_id) use($connection){
        $result = $connection->prepare("SELECT * FROM books WHERE id = :book_id");
        $result->execute(
            array(
                ":book_id" => $book_id
            )
        );

        $return = $result->fetch(PDO::FETCH_ASSOC);
        if($return == false){
            $return = array(
                "success" => false,
                "message" => "The book doesn't exist"
            );
        }

        Flight::json($return);
    });

    // update book by id
    Flight::route("PUT /books/@book_id", function($book_id) use($connection){

        $result = $connection->prepare("UPDATE books SET description = :description, image = :image WHERE id = :book_id");
        $result->execute(
            array(
                ":description"  => Flight::request()->data->description,
                ":image"        => Flight::request()->data->image,
                ":book_id"      => $book_id
            )
        );

        $status = false;
        $message = "Impossible to update the book";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Book updated";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

       Flight::json($return);
    });


    /**
    * COMMENTS - OK
    */

    // get all comments from a book
    Flight::route("GET /books/@book_id/comments", function($book_id) use($connection){
        $result = $connection->prepare("SELECT * FROM comments WHERE book_id = :book_id");
        $result->execute(
            array(
                ":book_id" => $book_id
            )
        );

        $return = $result->fetchAll(PDO::FETCH_CLASS);
        if(empty($return)) {
            $return = array(
                "success" => false,
                "message" => "No comments for this book"
            );
        }
        Flight::json($return); // return array of objects
    });

    // get comment by id and by book
    Flight::route("GET /books/@book_id/comments/@comment_id", function($book_id, $comment_id) use($connection){
        $result = $connection->prepare("SELECT * FROM comments WHERE book_id = :book_id AND id = :comment_id");
        $result->execute(
            array(
                ":book_id"      => $book_id,
                ":comment_id"   => $comment_id
            )
        );

        $return = $result->fetch(PDO::FETCH_ASSOC);
        if($return == false){
            $return = array(
                "success" => false,
                "message" => "The comment doesn't exist"
            );
        }
        Flight::json($return); // return object
    });

    // add a new comment
    Flight::route("POST /books/@book_id/comments", function($book_id) use($connection){

        $result = $connection->prepare("INSERT INTO comments(user_id, book_id, content, rating, created) VALUES(:user_id, :book_id, :content, :rating, :created)");
        $result->execute(
            array(
                ":content"  => Flight::request()->data->content,
                ":rating"   => Flight::request()->data->rating,
                ":book_id"  => $book_id,
                ":user_id"  => Flight::request()->data->user_id,
                ":created"  => date('Y-m-d H:i:s')
            )
        );

        $status = false;
        $message = "Impossible to post this comment";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Comment posted";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

       Flight::json($return);

    });

    // update comment by id and by book
    Flight::route("PUT /books/@book_id/comments/@comment_id", function($book_id, $comment_id) use($connection){

        $result = $connection->prepare("UPDATE comments SET content = :content, rating = :rating WHERE id = :comment_id");
        $result->execute(
            array(
                ":content"      => Flight::request()->data->content,
                ":rating"       => Flight::request()->data->rating,
                ":comment_id"   => $comment_id
            )
        );

        $status = false;
        $message = "Impossible to update this comment";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Comment updated";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });

    // remove comment by id
    Flight::route("DELETE /books/@book_id/comments/@comment_id", function($book_id, $comment_id) use($connection){

        $result = $connection->prepare("DELETE FROM comments WHERE id = :comment_id");
        $result->execute(
            array(
                ":comment_id"   => $comment_id
            )
        );

        $status = false;
        $message = "This comment don't exist or an error emerged";
        if($result->rowCount() == 1) {
            $status = true;
            $message = "Comment removed";
        }

        $return = array(
            "success" => $status,
            "message" => $message
        );

        Flight::json($return);

    });


    /**
     * START API
     */

    Flight::start();



?>