$( document ).ready(function(){
    $( "#flexRadioDefault1" ).click(function() {
    $.get('/showViruses' , data => {

          $('#content')
                .html('<table id="table1" class="table table-striped w-75 p-3">'
                + '<thead>'
                +'<tr>'
                +'<th scope="col">#</th>'
                +'<th scope="col">Name</th>'
                +'<th scope="col">Magnitude</th>'
                +'<th scope="col">Released On</th>'
                +'<th scope="col"></th>'
                +'<th scope="col"></th>'
                +'</tr>'
                +'</thead>'
                +'<tbody>');

         $.each(data,function(index){
             $('#table1')
                .append(
                    '<tr>'
                    +'<th>'+data[index].virusId+'</th>'
                    +'<th>'+data[index].name+'</th>'
                    +'<th>'+data[index].magnitude+'</th>'
                    +'<th>'+data[index].releaseOn+'</th>'
                    +'<th><a href="/edit/' + data[index].virusId +'"'+ 'class="btn btn-primary" role="button">Edit</a></th>'
                    +'<th><a href="/delete/' + data[index].virusId +'"'+ 'class="btn btn-danger" role="button">Delete</a></th>'
                    +'</tr>'
                );
         })
                +'/tbody>'
                +'</table>';
    }
    );
});
})

$( document ).ready(function(){
    $( "#flexRadioDefault2" ).click(function() {
    $.get('/showCapitals' , data => {

          $('#content')
                .html('<table id="table1" class="table table-striped w-75 p-3">'
                + '<thead>'
                +'<tr>'
                +'<th scope="col">#</th>'
                +'<th scope="col">Name</th>'
                +'<th scope="col">Latitude</th>'
                +'<th scope="col">Longitude</th>'
                +'</tr>'
                +'</thead>'
                +'<tbody>');

         $.each(data,function(index){
             $('#table1')
                .append(
                    '<tr>'
                    +'<th>'+data[index].capitalId+'</th>'
                    +'<th>'+data[index].name+'</th>'
                    +'<th>'+data[index].latitude+'</th>'
                    +'<th>'+data[index].longitude+'</th>'
                    +'</tr>'
                );
         })
                +'/tbody>'
                +'</table>';
    }
    );
});
})