package com.jrubiralta.marvelapp.data.mock

import com.appham.mockinizer.Method
import com.appham.mockinizer.RequestFilter
import okhttp3.mockwebserver.MockResponse

val mocks: Map<RequestFilter, MockResponse> = mapOf(

    RequestFilter(path = "/api/v1/items", query = "offset=0&count=20") to MockResponse().apply {
        setResponseCode(200)
        setBody(
            """[{
                    "id":1,
                    "link":"/api/v1/items/33",
                    "title":"Steppenwolf"
                },
                {
                    "id":2,
                    "link":"/api/v1/items/33",
                    "title":"The Wizard of Oz"
                },
                {
                    "id":3,
                    "link":"/api/v1/items/33",
                    "title":"Ulysses"
                },
                {
                    "id":4,
                    "link":"/api/v1/items/33",
                    "title":"Don Quixote"
                },
                {
                    "id":5,
                    "link":"/api/v1/items/33",
                    "title":"The Great Gatsby"
                },
                {
                    "id":6,
                    "link":"/api/v1/items/33",
                    "title":"Moby Dick"
                },
                {
                    "id":7,
                    "link":"/api/v1/items/33",
                    "title":"War and Peace"
                },
                {
                    "id":8,
                    "link":"/api/v1/items/33",
                    "title":"Hamlet"
                },
                {
                    "id":9,
                    "link":"/api/v1/items/33",
                    "title":"The Odyssey"
                },
                {
                    "id":10,
                    "link":"/api/v1/items/33",
                    "title":"Madame Bovary"
                },
                {
                    "id":11,
                    "link":"/api/v1/items/33",
                    "title":"The Divine Comedy"
                },
                {
                    "id":12,
                    "link":"/api/v1/items/33",
                    "title":"Pride And Prejudice"
                },
                {
                    "id":13,
                    "link":"/api/v1/items/33",
                    "title":"Anna Karenina"
                },
                {
                    "id":14,
                    "link":"/api/v1/items/33",
                    "title":"The Iliad"
                },
                {
                    "id":15,
                    "link":"/api/v1/items/33",
                    "title":"Heart Of Darkness"
                },
                {
                    "id":16,
                    "link":"/api/v1/items/33",
                    "title":"One Thousand And One Night"
                },
                {
                    "id":17,
                    "link":"/api/v1/items/33",
                    "title":"Invisible Man"
                },
                {
                    "id":18,
                    "link":"/api/v1/items/33",
                    "title":"The Trial"
                },
                {
                    "id":19,
                    "link":"/api/v1/items/33",
                    "title":"Belove"
                },
                {
                    "id":20,
                    "link":"/api/v1/items/33",
                    "title":"Robinson Crusoe"
                }]""".trimIndent()
        )
    },

    RequestFilter(path = "/api/v1/items", query = "offset=20&count=20") to MockResponse().apply {
        setResponseCode(200)
        setBody(
            """[{
                    "id":21,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":22,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":23,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":24,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":25,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":26,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":27,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":28,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":29,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":30,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":31,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":32,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":33,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":34,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":35,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":36,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":37,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":38,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":39,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                },
                {
                    "id":40,
                    "link":"/api/v1/items/33",
                    "title":"Tokio Blues"
                }]""".trimIndent()
        )
    },

    RequestFilter(path = "/api/v1/items") to MockResponse().apply {
        setResponseCode(200)
        setBody(
            """[{
                    "id":21,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":22,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":23,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":24,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":25,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":26,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":27,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":28,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":29,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":30,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":31,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":32,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":33,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":34,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":35,
                    "link":"/api/v1/items/33",
                    "title":"Test books"
                },
                {
                    "id":36,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":37,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":38,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":39,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                },
                {
                    "id":40,
                    "link":"/api/v1/items/33",
                    "title":"Test book"
                }]""".trimIndent()
        )
    },

    RequestFilter("/api/v1/items/33") to MockResponse().apply {
        setResponseCode(200)
        setBody(
            """{
                "id":1,
                "title":"The Shadow Of The Wind",
                "author":"Carlos Ruiz Zafón",
                "price":"15.99$",
                "imagePath":"api/v1/images/1.png"
       } """.trimIndent())
    },

    RequestFilter(path = "/api/v1/add-item", method = Method.POST) to MockResponse().apply {
        setResponseCode(200)
    }

)