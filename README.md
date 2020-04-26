https://api.github.com/repositories?since=5
Fetch list from above link and show in recycler view - Name(name), Description(description), Owner (login) and Owner image (avatar_url) 2. On scroll to end, fetch next page and continue loading
onClick show Details about that repository in different Fragment and Detail Screen should be swipeable
Ensure the following
1 - MVVM implementation
 2- cache implementation with Room DB, Network response should saved in DB. On no internet cache will be loaded and Cache will be cleared on new response received.
3 - Pagination : List should be paginated from DB, page wise both in List & viewPager
4 - List to show User's in First page, Detail screen to show personal details and Projects working on.


https://developer.github.com/v3/repos/#list-public-repositories
