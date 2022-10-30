//下一页   
function next(){   
    hideTable();   
    
    if(page>=maxPage){
        page--;
    }
    currentRow = pageSize * page;   
    maxRow = currentRow + pageSize;   
    if ( maxRow > numberRowsInTable ) maxRow = numberRowsInTable;   
    for ( var i = currentRow; i< maxRow; i++ ){   
        theTable.rows[i].style.display = '';   
    }   
    page++;
    showPage(); 
}   
  
//上一页   
function pre(){   
  
    hideTable();   
       
    page--;   
    if(page==0){
        page ++;
    }
    currentRow = pageSize * page;   
    maxRow = currentRow - pageSize;   
    if ( currentRow > numberRowsInTable ) currentRow = numberRowsInTable;   
    for ( var i = maxRow; i< currentRow; i++ ){   
        theTable.rows[i].style.display = '';   
    }   
    showPage(); 
}   
  
//第一页   
function first(){   
    hideTable();   
    page = 1;   
    for ( var i = 0; i<pageSize; i++ ){   
        theTable.rows[i].style.display = '';   
    }   
    showPage();    
}   
  
//最后一页   
function last(){   
    hideTable();   
    page = pageCount();   
    currentRow = pageSize * (page - 1);   
    for ( var i = currentRow; i<numberRowsInTable; i++ ){   
        theTable.rows[i].style.display = '';   
    }   
    showPage();     
}   
  
function hideTable(){   
    for ( var i = 0; i<numberRowsInTable; i++ ){   
        theTable.rows[i].style.display = 'none';   
    }   
}   
  
function showPage(){   
    pageNum.innerHTML = page;    
}   
  
//总共页数   
function pageCount(){   
    var count = 0;   
    if ( numberRowsInTable%pageSize != 0 ) count = 1; 
     maxPage=parseInt(numberRowsInTable/pageSize) + count;  
    return maxPage;   
}   