package app.diary.kotlin.farm

class PostData : ArrayList<PostData.PostDataItem>(){
    data class PostDataItem(
        var body: String,
        var id: Int,
        var title: String,
        var userId: Int
    )
}