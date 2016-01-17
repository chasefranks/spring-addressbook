<nav class="navbar navbar-inverse navbar-fixed-top">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="/">Spring Addressbook</a>
    </div>
    <div id="navbar" class="collapse navbar-collapse">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home</a></li>
        <li><a href="/entry/add">Add Entry</a></li>            
      </ul>
      <form class="navbar-form navbar-left" role="search" action="/searches" method="post">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Search" name="searchparm">
        </div>
        <button type="submit" class="btn btn-default">Search</button>
      </form>
    </div><!--/.nav-collapse -->
  </div>
</nav>