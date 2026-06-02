MAX_REVENUE_ITEMS = 100
PROFIT_CALCULATION_ITEMS = 12
QUARTER_MULTIPLIER = 4.0
SUCCESS = "SUCCESS"

def initRevenueExpense(inputRec, quarter):
    for i in range(MAX_REVENUE_ITEMS):
        initRevenueExpense.revenue[i] = 0
        inputRec.expense[i] = corpExpense[quarter][i]

def UpdateCorpDatabase(empRec):
    pass

def calculateEstimatedRevenue(ytdRevenue, quarter):
    if quarter == 0:
        raise ValueError("Quarter cannot be zero.") 
    return(ytdRevenue * QUARTER_MULTIPLIER) / quarter 

def UpdateColorAndStatus(prevColor):
    newColor = prevColor
    status = SUCCESS
    return newColor, status

def calculateProfit(expenseType, revenue, expense):
    profit = [0] * PROFIT_CALCULATION_ITEMS

    for i in range(PROFIT_CALCULATION_ITEMS):
        if expenseType == 1:
            profit[i] = revenue[i] - expense.type1[i]
        elif expenseType == 2:
            profit[i] = revenue[i] - expense.type2[i]
        elif expenseType == 3:
            profit[i] = revenue[i] - expense.type3[i]

    return profit

def HandleStuff(inputRec, crntQtr, empRec, ytdRevenue, prevColor, expenseType):
    initRevenueExpense(inputRec, crntQtr)
    updateCorpDatabase(empRec)
    estimRevenue = calculateEstimatedRevenue(ytdRevenue, crntQtr)
    newColor, status = UpdateColorAndStatus(prevColor)

    profit = calculateProfit(expenseType, inputRec.revenue, inputRec.expense)
    return estimRevenue, newColor, status, profit
