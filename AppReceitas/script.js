const recipeList = document.querySelector('.recipe-list')
const form = document.querySelector('.search-form')

form.addEventListener('submit',function(event){
    event.preventDefault()
    const inputValue = event.target[0].value

    searchRecipes(inputValue)
})

async function searchRecipes(ingredient){
    const response = await fetch (`https://www.themealdb.com/api/json/v1/1/filter.php?i=${ingredient}`)
    const data = await response.json()
    console.log(data)

    showRecipes(data.meals)
}

function showRecipes(recipes){
    recipeList.innerHTML = recipes.map(
        (element) => `
        <div class="recipe-card">
            <img src="${element.strMealThumb}" alt="receita-foto">
            <h3>${element.strMeal}</h3>
        </div>
        `  
    ).join('')
}