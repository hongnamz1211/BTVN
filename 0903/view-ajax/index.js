let index = 0;

function displayCate(category) {
    return `<option value="${category.id}">${category.name}</option>`
}

function getCate() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/cate`,
        success: function (data) {
            let content = "";
            for (let i = 0; i < data.length; i++) {
                content += displayCate(data[i]);
            }
            document.getElementById("category").innerHTML = content;
        }
    });
}

function displayCategory(category) {
    return `<tr>
                <td>${category.id}</td>
                <td>${category.name}</td>
                <td><button onclick="showEditCategory(${category.id})">Edit</button></td>
                <td><button onclick="deleteCategory(${category.id})">Delete</button></td>
            </tr>`
}

function displayProduct(product) {
    return `<tr>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td>${product.image}</td>
                <td>${product.category.id}</td>
                <td>${product.category.name}</td>
                <td><button onclick="showEditProduct(${product.id})">Edit</button></td>
                <td><button onclick="deleteProduct(${product.id})">Delete</button></td>
                <td><button onclick="viewProduct(${product.id})">View</button></td>
            </tr>`
}

function getCategory() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/cate`,
        success: function (data) {
            let content = `<tr>
                                <th>Name</th>
                                <th>Description</th>
                                <th colspan="3">Action</th>
                            </tr>`;
            for (let i = 0; i < data.length; i++) {
                content += displayCategory(data[i]);
            }
            document.getElementById("categoryList").innerHTML = content;
            document.getElementById("form").hidden = true;
            document.getElementById("form-category").hidden = true;
            document.getElementById("productList").hidden = true;
            document.getElementById("categoryList").hidden = false;
        }
    });
}

function getProduct() {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products`,
        success: function (data) {
            let content = `<tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Image</th>
                                <th>Category Id</th>
                                <th>Category Name</th>
                                <th colspan="3">Action</th>
                            </tr>`;
            for (let i = 0; i < data.length; i++) {
                content += displayProduct(data[i]);
            }
            document.getElementById("productList").innerHTML = content;
            document.getElementById("form").hidden = true;
            document.getElementById("form-category").hidden = true;
            document.getElementById("productList").hidden = false;
            document.getElementById("categoryList").hidden = true;
        }
    });
}

function viewProduct(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/${id}`,
        success: function (data) {
            let content = `<tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Image</th>
                                <th>Category Id</th>
                                <th>Category Name</th>
                                <th colspan="2">Action</th>
                            </tr>
                            <tr>
                                 <td>${data.name}</td>
                                 <td>${data.price}</td>
                                 <td>${data.description}</td>
                                 <td>${data.image}</td>
                                 <td>${data.category.id}</td>
                                 <td>${data.category.name}</td>
                                 <td><button onclick="showEditProduct(${data.id})">Edit</button></td>
                                 <td><button onclick="deleteProduct(${data.id})">Delete</button></td>
                            </tr>`;
            document.getElementById("productList").innerHTML = content;
            document.getElementById("form").hidden = true;
        }
    });
}

function deleteCategory(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/products/category/${id}`,
        success: function () {
            getCategory();
        }
    });
}

function deleteProduct(id) {
    $.ajax({
        type: "DELETE",
        url: `http://localhost:8080/api/products/${id}`,
        success: function () {
            getProduct();
        }
    });
}

function searchProduct() {
    let search = document.getElementById("search").value;
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/search?search=${search}`,
        success: function (data) {
            let content = `<tr>
                                <th>Name</th>
                                <th>Price</th>
                                <th>Description</th>
                                <th>Image</th>
                                <th>Category Id</th>
                                <th>Category Name</th>
                                <th colspan="3">Action</th>
                            </tr>`;
            for (let i = 0; i < data.length; i++) {
                content += displayProduct(data[i]);
            }
            document.getElementById('productList').innerHTML = content;
            document.getElementById('searchForm').reset();
        }
    });
    event.preventDefault();
}

function createCategory() {
    let name = $('#name').val();
    let newCategory = {
        name: name
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newCategory),
        url: `http://localhost:8080/api/products/category`,
        success: function () {
            getCategory();
        }
    });
    event.preventDefault();
}

function createProduct() {
    let name = $('#name').val();
    let price = $('#price').val();
    let description = $('#description').val();
    let image = $('#image').val();
    let category = $('#category').val();
    let newProduct = {
        name: name,
        price: price,
        description: description,
        image: image,
        category: {
            id: category
        }
    };

    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "POST",
        data: JSON.stringify(newProduct),
        url: `http://localhost:8080/api/products`,
        success: function () {
            getProduct();
        }
    });
    event.preventDefault();
}

function displayFormCreateCate() {
    document.getElementById("form-category").reset();
    document.getElementById("form").hidden = true;
    document.getElementById("form-category").hidden = false;
    document.getElementById("productList").hidden = true;
    document.getElementById("categoryList").hidden = false;
    document.getElementById("form-button").onclick = function () {
        createCategory();
    }
}

function displayFormCreate() {
    document.getElementById("form").reset();
    document.getElementById("form").hidden = false;
    document.getElementById("form-category").hidden = true;
    document.getElementById("productList").hidden = false;
    document.getElementById("categoryList").hidden = true;
    document.getElementById("form-button").onclick = function () {
        createProduct();
    }
}

function showEditProduct(id) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/${id}`,
        success: function (data) {
            $('#name').val(data.name);
            $('#price').val(data.price);
            $('#description').val(data.description);
            $('#image').val(data.image);
            $('#category').val(data.category.id);
            index = data.id;
            document.getElementById("form").hidden = false;
            document.getElementById("form-button").onclick = function () {
                editProduct()
            }
        }
    });
}


function editProduct() {
    let name = $('#name').val();
    let price = $('#price').val();
    let description = $('#description').val();
    let image = $('#image').val();
    let category = $('#category').val();
    let editProduct = {
        name: name,
        price: price,
        description: description,
        image: image,
        category: {
            id: category
        }
    };
    $.ajax({
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        type: "PUT",
        data: JSON.stringify(editProduct),
        url: `http://localhost:8080/api/products/${index}`,
        success: function () {
            getProduct();
        }
    });
    event.preventDefault();
}

function getProductByPage(page) {
    $.ajax({
        type: "GET",
        url: `http://localhost:8080/api/products/page?page=${page}`,
        success: function (data) {
            let array = data.content
            let content = '<tr>\n' +
                '<th>ProductName</th>\n' +
                '<th>Price</th>\n' +
                '<th>Desciption</th>\n' +
                '<th>Image</th>\n' +
                '<th>Category</th>\n' +
                '<th colspan="2">Action</th>\n' +
                '</tr>';
            for (let i = 0; i < array.length; i++) {
                content += displayProduct(array[i]);
            }
            document.getElementById("productList").innerHTML = content;
            document.getElementById("displayPage").innerHTML = displayPage(data)
            document.getElementById("form").hidden = true;
            if (data.pageable.pageNumber === 0) {
                document.getElementById("backup").hidden = true
            }
            if (data.pageable.pageNumber + 1 === data.totalPages) {
                document.getElementById("next").hidden = true
            }
        }
    });
}

function displayPage(data) {
    return `<button class="btn btn-primary" id="backup" onclick="isPrevious(${data.pageable.pageNumber})">Previous</button>
    <span>${data.pageable.pageNumber + 1} | ${data.totalPages}</span>
    <button class="btn btn-primary" id="next" onclick="isNext(${data.pageable.pageNumber})">Next</button>`
}

function isPrevious(pageNumber) {
    getProductByPage(pageNumber - 1)
}

function isNext(pageNumber) {
    getProductByPage(pageNumber + 1)
}

getProduct()
getCate()
