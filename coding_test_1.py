import pandas as pd
import numpy as np
import matplotlib.pyplot as plt
import seaborn as sns

def main():

    s = pd.Series(np.random.randn(10).cumsum(), index=np.arange(0,100,10))
    s.plot()
    plt.show()

    df = pd.DataFrame(np.random.randn(10,4).cumsum(0),
        columns=['A','B','C','D'],
        index=np.arange(0,100,10))
    df.plot()
    plt.show()

    fig, axes = plt.subplots(2,1)
    data = pd.Series(np.random.rand(16), index=list('abcdefghijklmnop'))
    data.plot.bar(ax=axes[0], color='k', alpha=0.7)
    data.plot.barh(ax=axes[1], color='k', alpha=0.7)
    plt.show()

    df = pd.DataFrame(np.random.rand(6,4), 
        index=['one','two','three','four','five','six'],
        columns=pd.Index(['A','B','C','D'], name='Genus'))
    print(df)
    df.plot.bar()
    plt.show()

    df.plot.barh(stacked=True, alpha=0.5)
    plt.show()

    tips = pd.read_csv('LEC/examples/tips.csv')
    party_counts = pd.crosstab(tips['day'], tips['size'])
    print(party_counts)
    party_counts = party_counts.loc[:, 2:5]
    party_pcts = party_counts.div(party_counts.sum(1), axis=0)
    print(party_pcts)

    party_pcts.plot.bar()
    plt.show()

    tips = pd.read_csv('LEC/examples/tips.csv')
    tips['tip_pct'] = tips['tip'] / (tips['total_bill'] - tips['tip'])
    print(tips.head())
    sns.barplot(x='tip_pct', y='day', data=tips, orient='h')
    plt.show()

    sns.barplot(x='tip_pct', y='day', hue='time', data=tips, orient='h')
    sns.set(style='whitegrid')
    plt.show()

    tips = pd.read_csv('LEC/examples/tips.csv')
    tips['tip_pct'] = tips['tip'] / (tips['total_bill'] - tips['tip'])
    tips['tip_pct'].plot.hist(bins=50) 
    plt.show()

    tips['tip_pct'].plot.density()
    plt.show() 

    tips['tip_pct'].plot.kde()
    plt.show()

    comp1 = np.random.normal(0,1,size=200)
    comp2 = np.random.normal(10,2,size=200)

    values = pd.Series(np.concatenate([comp1, comp2]))
    sns.distplot(values, bins=100, color='k')
    plt.show()

    macro = pd.read_csv('LEC/examples/macrodata.csv')
    data = macro[['cpi', 'm1', 'tbilrate', 'unemp']]
    trans_data = np.log(data).diff().dropna()
    print(trans_data[-5:])

    sns.regplot('m1', 'unemp', data=trans_data)
    plt.title('Changes in log %s versus log %s' % ('m1', 'unemp'))
    plt.show()

    sns.pairplot(trans_data, diag_kind='kde', plot_kws={'alpha':0.2})
    plt.show()

    tips = pd.read_csv('LEC/examples/tips.csv')
    tips['tip_pct'] = tips['tip'] / (tips['total_bill'] - tips['tip'])
    sns.factorplot(x='day',y='tip_pct', hue='time', col='smoker', kind='bar', data=tips[tips.tip_pct < 1])
    plt.show()

    sns.factorplot(x='day', y='tip_pct', row='time', col='smoker', kind='bar', data=tips[tips.tip_pct < 1])
    plt.show()
    sns.factorplot(x='tip_pct', y='day', kind='box', data=tips[tips.tip_pct < 0.5])
    plt.show()

if __name__ == '__main__': # main()
    main()